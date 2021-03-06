var viewType = '';

function initEditSourcePropertyDlg(editDlg) {
	validateAndSubmitAndUpdateSourcePropertyForm(editDlg);
};

function initAddSourcePropertyDlg(addDlg) {
	validateAndSubmitAndUpdateSourcePropertyForm(addDlg);
};

function initializeSourceSearch() {
	initDeleteConfirmations();
	viewType = 'source';
}

function initDeleteConfirmations() {
	$('[data-toggle=delete-source-property-confirm]').confirmation({
		btnOkLabel: 'Jah',
		btnCancelLabel: 'Ei',
		title: 'Palun kinnita allika atribuudi kustutamine',
		onConfirm: deleteSourceProperty
	});
	$('[data-toggle=delete-source-confirm]').confirmation({
		btnOkLabel: 'Jah',
		btnCancelLabel: 'Ei',
		title: 'Palun kinnita allika kustutamine',
		onConfirm: executeValidateSourceDelete
	});
}

function validateAndSubmitAndUpdateSourcePropertyForm(dlg) {
	dlg.find('button[type="submit"]').off('click').on('click', function (e) {
		e.preventDefault();
		let form = dlg.find('form');
		if (!checkRequiredFields(form)) {
			return;
		}

		let sourceId = $(this).attr("data-source-id");
		$.ajax({
			url: form.attr('action'),
			data: form.serialize(),
			method: 'POST',
		}).done(function (data) {
			dlg.modal('hide');
			$('#sourceSearchResult_' + sourceId).replaceWith(data);
			initDeleteConfirmations();
		}).fail(function (data) {
			console.log(data);
			openAlertDlg('Salvestamine ebaõnnestus');
		});
	});
};

function deleteSourceProperty() {
	let sourcePropertyId = $(this).data('sourcePropertyId');
	let sourceId = $(this).data('sourceId');
	let deleteSourcePropertyUrl = applicationUrl + 'delete_source_property/' + sourcePropertyId;
	$.get(deleteSourcePropertyUrl).done(function (data) {
		$('#sourceSearchResult_' + sourceId).replaceWith(data);
		initDeleteConfirmations();
	}).fail(function (data) {
		console.log(data);
		openAlertDlg('Kustutamine ebaõnnestus');
	});
};

function initEditSourceTypeSelectDlg(selectDlg) {
	let selectControl = selectDlg.find('select');
	configureSelectDlg(selectControl, selectDlg);

	selectControl.off('click').on('click', function (e) {
		submitAndUpdateSourceType(selectDlg)
	});
	selectControl.off('keydown').on('keydown', function (e) {
		if (e.key === "Enter") {
			submitAndUpdateSourceType(selectDlg)
		}
	});
};

function submitAndUpdateSourceType(selectDlg) {
	let form = selectDlg.find('form');
	let sourceId = form.find('[name=sourceId]').val();
	$.ajax({
		url: form.attr('action'),
		data: form.serialize(),
		method: 'POST',
	}).done(function (data) {
		selectDlg.modal('hide');
		$('#sourceSearchResult_' + sourceId).replaceWith(data);
		initDeleteConfirmations();
	}).fail(function (data) {
		console.log(data);
		openAlertDlg('Muutmine ebaõnnestus');
	});
};

$.fn.addSourceAndSourceLinkPlugin = function() {
	var main = $(this);
	main.on('click', function(e) {
		e.preventDefault();
		$("#noSourcesFoundDiv").hide();
		$("#addSourceDiv").show();
		let duplicateCancelBtnFooter = main.closest('.modal-content').find('.modal-footer').last();
		duplicateCancelBtnFooter.hide();
		displayRemoveButtons();
	});
};

$.fn.addSourcePropertyGroup = function() {
	var main = $(this);
	main.on('click', function(e) {
		e.preventDefault();
		let sourcePropertyGroupElement = $("#source_property_element").find('[name="sourcePropertyGroup"]').last();
		createAndAttachCopyFromLastSourceItem(sourcePropertyGroupElement);
		displayRemoveButtons();
	});
};

$.fn.removeSourcePropertyGroup = function() {
	var main = $(this);
	main.on('click', function(e) {
		e.preventDefault();
		main.closest('[name="sourcePropertyGroup"]').remove();
		displayRemoveButtons();
	});
};

function displayRemoveButtons() {
	$('[name="removePropertyGroupBtn"]').each(function (i, v) {
		if ($("#source_property_element").find('[name="propertyValue"]').length === 1) {
			$(this).hide();
		} else {
			$(this).show();
		}
	});
};

function createAndAttachCopyFromLastSourceItem(parentElement) {
	let copyOfLastElement = parentElement.clone(true);
	copyOfLastElement.find('textArea').val(null);
	parentElement.after(copyOfLastElement);
};

function executeValidateSourceDelete() {
	let sourceId = $(this).data('sourceId');
	let validateUrl = applicationUrl + 'validate_delete_source/' + sourceId;
	let deleteUrl = applicationUrl + 'delete_source/' + sourceId;
	$.get(validateUrl).done(function (data) {
		let response = JSON.parse(data);
		if (response.status === 'ok') {
			deleteSourceAndUpdateSearch(deleteUrl);
		} else if (response.status === 'invalid') {
			openAlertDlg(response.message);
		} else {
			openAlertDlg("Allika eemaldamine ebaõnnestus.");
		}
	}).fail(function (data) {
		openAlertDlg("Allika eemaldamine ebaõnnestus.");
		console.log(data);
	});
};

function deleteSourceAndUpdateSearch(deleteUrl) {
	$.get(deleteUrl).done(function () {
		window.location = applicationUrl + 'sourcesearch';
	}).fail(function (data) {
		openAlertDlg("Allika eemaldamine ebaõnnestus.");
		console.log(data);
	});
};

function addSource(addSourceForm) {
	if (!checkRequiredFields(addSourceForm)) {
		return;
	}

	$.ajax({
		url: addSourceForm.attr('action'),
		data: JSON.stringify(addSourceForm.serializeJSON()),
		method: 'POST',
		dataType: 'json',
		contentType: 'application/json'
	}).done(function(sourceId) {
		window.location = applicationUrl + 'sourcesearch/' + sourceId;
	}).fail(function(data) {
		console.log(data);
		openAlertDlg('Allika lisamine ebaõnnestus');
	});
}

function addSourceAndSourceLink(addSourceForm) {
	if (!checkRequiredFields(addSourceForm)) {
		return;
	}

	let sourceModal = addSourceForm.closest('.modal');
	let addSourceLinkForm = addSourceForm.closest('form[name="sourceLinkForm"]');
	let sourceOwnerIdInput = addSourceLinkForm.find('input[name="id"]');
	let sourceOwnerCodeInput = addSourceLinkForm.find('input[name="opCode"]');

	addSourceForm.append(sourceOwnerIdInput);
	addSourceForm.append(sourceOwnerCodeInput);

	var successCallbackName = sourceModal.attr("data-callback");
	var successCallbackFunc = undefined;
	if (successCallbackName) {
		successCallbackFunc = () => eval(successCallbackName);
	} else {
		successCallbackFunc = () => $('#refresh-details').trigger('click');
	}

	$.ajax({
		url: applicationUrl + 'create_source_and_source_link',
		data: JSON.stringify(addSourceForm.serializeJSON()),
		method: 'POST',
		dataType: 'json',
		contentType: 'application/json'
	}).done(function() {
		sourceModal.modal('hide');
		successCallbackFunc();
	}).fail(function(data) {
		console.log(data);
		openAlertDlg('Allika lisamine ebaõnnestus');
	});
}

$(function(){

	$(document).on('show.bs.modal', '#sourceActivityLogDlg', function(e) {
		var dlg = $(this);
		var link = $(e.relatedTarget);
		var url = link.attr('href');
		dlg.find('.close').focus();
		dlg.find('.modal-body').html(null);
		$.get(url).done(function(data) {
			dlg.find('.modal-body').html(data);
		});
	});

	$(document).on("click", "#addSourceSubmitBtn", function() {
		let addSourceForm = $(this).closest('form');
		if (viewType === 'source') {
			addSource(addSourceForm);
		} else {
			addSourceAndSourceLink(addSourceForm);
		}
	});
});