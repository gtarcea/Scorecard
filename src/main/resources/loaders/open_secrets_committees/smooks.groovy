
def persister = { s, data, flushing ->
    println(data)
    s.saveOrUpdate(data);
}