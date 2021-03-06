package eki.ekilex.service.db;

import static eki.ekilex.data.db.Tables.FORM_FREQ;
import static eki.ekilex.data.db.Tables.FREQ_CORP;
import static eki.ekilex.data.db.Tables.MORPH_FREQ;
import static eki.ekilex.data.db.Tables.WORD_FREQ;

import java.math.BigDecimal;
import java.util.List;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import eki.ekilex.data.api.FormFreq;
import eki.ekilex.data.api.FreqCorp;
import eki.ekilex.data.api.FreqCorpId;
import eki.ekilex.data.api.MorphFreq;
import eki.ekilex.data.api.WordFreq;

@Component
public class CorpFrequencyDbService {

	@Autowired
	private DSLContext create;

	public List<FreqCorpId> getFreqCorps() {
		return create.selectFrom(FREQ_CORP).orderBy(FREQ_CORP.CORP_DATE).fetchInto(FreqCorpId.class);
	}

	public Long createCorpFreq(FreqCorp freqCorp) {
		return create
				.insertInto(FREQ_CORP, FREQ_CORP.NAME, FREQ_CORP.CORP_DATE, FREQ_CORP.IS_PUBLIC)
				.values(freqCorp.getName(), freqCorp.getCorpDate(), freqCorp.isPublic())
				.returning(FREQ_CORP.ID)
				.fetchOne()
				.getId();
	}

	public void updateFreqCorp(FreqCorpId freqCorp) {
		create
				.update(FREQ_CORP)
				.set(FREQ_CORP.NAME, freqCorp.getName())
				.set(FREQ_CORP.CORP_DATE, freqCorp.getCorpDate())
				.set(FREQ_CORP.IS_PUBLIC, freqCorp.isPublic())
				.where(FREQ_CORP.ID.eq(freqCorp.getId()))
				.execute();
	}

	public void createFormFreqs(FormFreq formFreq) {
		create
				.insertInto(FORM_FREQ, FORM_FREQ.FREQ_CORP_ID, FORM_FREQ.FORM_ID, FORM_FREQ.VALUE, FORM_FREQ.RANK)
				.values(formFreq.getFreqCorpId(), formFreq.getFormId(), BigDecimal.valueOf(formFreq.getValue()), formFreq.getRank())
				.execute();
	}

	public void createMorphFreq(MorphFreq morphFreq) {
		create
				.insertInto(MORPH_FREQ, MORPH_FREQ.FREQ_CORP_ID, MORPH_FREQ.MORPH_CODE, MORPH_FREQ.VALUE, MORPH_FREQ.RANK)
				.values(morphFreq.getFreqCorpId(), morphFreq.getMorphCode(), BigDecimal.valueOf(morphFreq.getValue()), morphFreq.getRank())
				.execute();
	}

	public void createWordFreq(WordFreq wordFreq) {
		create
				.insertInto(WORD_FREQ, WORD_FREQ.FREQ_CORP_ID, WORD_FREQ.WORD_ID, WORD_FREQ.VALUE, WORD_FREQ.RANK)
				.values(wordFreq.getFreqCorpId(), wordFreq.getWordId(), BigDecimal.valueOf(wordFreq.getValue()), wordFreq.getRank())
				.execute();
	}

}
