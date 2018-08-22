package eki.wordweb.data;

import java.util.List;

import eki.common.data.AbstractDataObject;

public class Collocation extends AbstractDataObject {

	private static final long serialVersionUID = 1L;

	private String value;

	private String definition;

	private List<String> collocUsages;

	private List<TypeCollocMember> collocMembers;

	private boolean containsOtherWords;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}

	public List<String> getCollocUsages() {
		return collocUsages;
	}

	public void setCollocUsages(List<String> collocUsages) {
		this.collocUsages = collocUsages;
	}

	public List<TypeCollocMember> getCollocMembers() {
		return collocMembers;
	}

	public void setCollocMembers(List<TypeCollocMember> collocMembers) {
		this.collocMembers = collocMembers;
	}

	public boolean isContainsOtherWords() {
		return containsOtherWords;
	}

	public void setContainsOtherWords(boolean containsOtherWords) {
		this.containsOtherWords = containsOtherWords;
	}

}
