package eki.ekilex.data;

import java.util.List;

import eki.common.data.AbstractDataObject;

public class UserContextData extends AbstractDataObject {

	private static final long serialVersionUID = 1L;

	private Long userId;

	private String userName;

	private DatasetPermission userRole;

	private String userRoleDatasetCode;

	private Tag activeTag;

	private List<String> tagNames;

	private List<String> preferredDatasetCodes;

	private List<String> synCandidateLangCodes;

	private List<String> synMeaningWordLangCodes;

	public UserContextData(Long userId, String userName, DatasetPermission userRole, String userRoleDatasetCode, Tag activeTag, List<String> tagNames,
			List<String> preferredDatasetCodes, List<String> synCandidateLangCodes, List<String> synMeaningWordLangCodes) {
		this.userId = userId;
		this.userName = userName;
		this.userRole = userRole;
		this.userRoleDatasetCode = userRoleDatasetCode;
		this.activeTag = activeTag;
		this.tagNames = tagNames;
		this.preferredDatasetCodes = preferredDatasetCodes;
		this.synCandidateLangCodes = synCandidateLangCodes;
		this.synMeaningWordLangCodes = synMeaningWordLangCodes;
	}

	public Long getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public DatasetPermission getUserRole() {
		return userRole;
	}

	public String getUserRoleDatasetCode() {
		return userRoleDatasetCode;
	}

	public Tag getActiveTag() {
		return activeTag;
	}

	public List<String> getTagNames() {
		return tagNames;
	}

	public List<String> getPreferredDatasetCodes() {
		return preferredDatasetCodes;
	}

	public List<String> getSynCandidateLangCodes() {
		return synCandidateLangCodes;
	}

	public List<String> getSynMeaningWordLangCodes() {
		return synMeaningWordLangCodes;
	}

}
