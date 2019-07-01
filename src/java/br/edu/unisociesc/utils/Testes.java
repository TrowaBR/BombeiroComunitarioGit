/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unisociesc.utils;

import br.edu.unisociesc.model.TiposGraduacao;
import br.edu.unisociesc.model.Unidade;
import br.edu.unisociesc.model.Usuario;
import java.util.Date;

/**
 *
 * @author Pichau
 */
public class Testes {

    public static Usuario novoUsuario01() {
        return new Usuario(1, "BC Hening", "Eduardo Hening", new Date(1980, 0, 0), "Masculino", TiposGraduacao.BC, new Date(2017, 1, 1), "admin", "Rua Teste", 100, "", "", "11111-222", "SC", "11223344-5", "111.111.111-11", "teste@e-mail.com", "(047) 99999-5555", "", "", "", "", "", "", "Ativo");
    }

    public static Unidade novaUnidade01() {
        return new Unidade(1, "Centro", new Date(0, 0, 0, 4, 0), new Date(0, 0, 0, 12, 0), 4, 4, new Date(0, 0, 0, 0, 0), new Date(0, 0, 0, 0, 0), new Date(0, 0, 1, 0, 0), new Date(0, 0, 1, 0, 0), true, "Rua teste", "", 105, "Bluemnau");
    }

    public static Unidade novaUnidade02() {
        return new Unidade(1, "COBOM", new Date(0, 0, 0, 4, 0), new Date(0, 0, 0, 12, 0), 4, 4, new Date(0, 0, 0, 0, 0), new Date(0, 0, 0, 0, 0), new Date(0, 0, 1, 0, 0), new Date(0, 0, 1, 0, 0), true, "Rua teste", "", 105, "Bluemnau");
    }
}