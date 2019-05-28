import express from 'express';
import jwt from 'jsonwebtoken';
import dbUtil from '../utils/dbUtil'

const router = express.Router();

router.post('/add', (req, res) => {

    if (req.body.nmEmpresa || req.body.cdCnpj || req.body.nmFuncionario || req.body.nmEmail || req.body.nmSenha) {

        let nomeEmpresa = req.body.nmEmpresa, cnpj = req.body.cdCnpj, nomeFuncionario = req.body.nmFuncionario, email = req.body.nmEmail, nomeSenha = req.body.nmSenha;

        global.conn.request()
            .query(`SELECT * FROM TB_EMPRESA WHERE CDCNPJ = '${cnpj}'`)
            .then(result => {
                if (result.recordset.length == 0) {
                    global.conn.request()
                        .query(`SELECT * FROM TB_FUNCIONARIO WHERE NMEMAIL = '${email}'`)
                        .then(result => {

                            if (result.recordset.length == 0) {

                                global.conn.request()
                                    .query(`INSERT INTO TB_EMPRESA VALUES ('${nomeEmpresa}', '${cnpj}')`)
                                    .then(() => {

                                        global.conn.request()
                                            .query(`INSERT INTO TB_FUNCIONARIO VALUES('${nomeFuncionario}', '${email}', '${nomeSenha}', (SELECT IDEMPRESA FROM TB_EMPRESA WHERE CDCNPJ = '${cnpj}'), NULL, 1, '99999')`)
                                            .then(() => {

                                                res.json({ "message": "Cadastrado com sucesso!", "success": true });

                                            }).catch(err => console.error(err))

                                    }).catch(err => console.error(err))
                            } else {
                                res.json({ "message": "Email já cadastrado!", "success": false });
                            }
                        }).catch(err => console.error(err))
                } else {
                    res.json({ "message": "Empresa já cadastrada!", "success": false });
                }
            }).catch(err => console.error(err));
    } else {
        res.json({ "message": 'Preencha todos os campos!' })
    }
});

export default router;