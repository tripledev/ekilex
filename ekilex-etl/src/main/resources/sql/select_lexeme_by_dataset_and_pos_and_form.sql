select
	l.id lexeme_id,
	array_agg(l.meaning_id) meaning_ids
from
	lexeme l,
	word w
where
	l.dataset_code = :dataset
	and l.word_id = w.id
	and w.lang = :lang
and exists (
	select
		f2.id
	from
		paradigm p2,
		form f2
	where
		p2.word_id = w.id
		and f2.paradigm_id = p2.id
		and f2.value = :form
)
and exists (
	select
		lp.id
	from
		lexeme_pos lp
	where
		lp.lexeme_id = l.id
		and lp.pos_code = :posCode
)
group by l.id