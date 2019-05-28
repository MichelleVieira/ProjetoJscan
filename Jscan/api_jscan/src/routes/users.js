import express from 'express';
import passport from 'passport';

import dbUtil from '../utils/dbUtil'

const router = express();

// passport.authenticate('jwt', {session: false})

router.get('/get/:id', (req, res) => {
    //teste de rota
    
    dbUtil.queryFromRoutes(`SELECT * FROM TB_FUNCIONARIO WHERE IDFUNCIONARIO = ${req.params.id}`, res);

    // res.json({'message':"ok"})

    //para criação de rotas, só fazer o processo padrão de criar rotas, protegê-las com
    //o passport.authenticate , e chamar o SQLStatement, passando a query e o response

    //nesta rota tem o modelo de como usar os parametros de rota tambem, mas nem sempre elas serão usadas    
});

export default router;