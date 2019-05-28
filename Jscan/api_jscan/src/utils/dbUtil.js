export default {
    queryFromRoutes: (sqlQuery, res) => {
        global.conn.request()
            .query(sqlQuery)
            .then(result => res.json(result.recordset))
            .catch(err => console.error(err));
    },
    query: (sqlQuery) => {
        global.conn.request()
            .query(sqlQuery)
            .then(result => { console.log(result.recordset, 'AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA'); return result.recordset })
            .catch(err => { console.error(err); return null });
    },
}