
def persister = { s, data, flushing ->
    s.saveOrUpdate(data);
}