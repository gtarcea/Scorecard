
def persister = { s, data, flushing ->
    //println(data)
    if (data.registrant)
    {
        s.saveOrUpdate(data.registrant);
    }
    
    if (data.client)
    {
        s.saveOrUpdate(data.client);
    }
    
    saveHashSetOfValues(s, data.governmentEntities);
    saveHashSetOfValues(s, data.foreignEntities);
    saveHashSetOfValues(s, data.lobbyists);
    saveHashSetOfValues(s, data.issues);
    
    s.saveOrUpdate(data);
}

def saveHashSetOfValues(session, values)
{
    if (values && values.size() != 0)
    {
        for (v in values)
        {
            session.saveOrUpdate(v);
        }
    }
}