
create index activity_entity_name_owner_name_event_on_idx on activity_log(entity_name, owner_name, (date_part('epoch', event_on) * 1000));

update activity_log set entity_name = 'LEXEME_NOTE' where owner_name = 'LEXEME' and entity_name = 'NOTE';
