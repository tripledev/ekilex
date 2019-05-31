function initialise() {
	$(document).on("click", "#addDatasetSubmitBtn", function(e) {
		e.preventDefault();
		var thisForm = $("#addDatasetForm");
		let fieldsFilled = checkRequiredFields(thisForm)

		if (fieldsFilled) {
			checkAndAddDataset(thisForm);
		}
	});

	$('.delete-dataset-confirm').confirmation({
		btnOkLabel : 'Jah',
		btnCancelLabel : 'Ei',
		title : 'Kas kustutame sõnakogu?',
		onConfirm : function() {
			let code = $(this).data('code');
			deleteDataset(code);
		}
	});

	$('#addDatasetForm').find('input[name="code"]').on('blur', function (e) {
		$('#codeExistsError').hide();
	})

}

function deleteDataset(datasetCode) {
	let deleteUrl = applicationUrl + 'delete_dictionary/' + datasetCode;

	$.get(deleteUrl).done(function (data) {
		let response = JSON.parse(data);
		if (response.status === 'ok') {
			window.location = applicationUrl + 'dictionaries';
		} else if (response.status === 'invalid') {
			openAlertDlg(response.message);
		} else {
			openAlertDlg("Sõnakogu eemaldamine ebaõnnestus.");
		}
	}).fail(function (data) {
		openAlertDlg("Allika eemaldamine ebaõnnestus.");
		console.log(data);
	});
}

function checkAndAddDataset(addDatasetForm) {
	let newCodeField = addDatasetForm.find('input[name="code"]');
	let validateUrl = applicationUrl + 'data/validate_create_dictionary/' + newCodeField.val();

	$.get(validateUrl).done(function (data) {
		let responseCode = data;

		if (responseCode === 'ok') {
			addDatasetForm.submit();
		} else if (responseCode === 'code_exists') {
			showFieldError(newCodeField, "Sellise koodiga sõnakogu on olemas.");
		} else {
			openAlertDlg("Sõnakogu lisamine ebaõnnestus, veakood: '" + responseCode + "'");
		}
	}).fail(function (data) {
		openAlertDlg("Sõnakogu lisamine ebaõnnestus.");
		console.log(data);
	});

}

