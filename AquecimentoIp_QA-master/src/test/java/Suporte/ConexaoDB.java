package Suporte;

import javax.swing.*;
import java.sql.*;

public class ConexaoDB {


        /** Usada para a conexao com o banco de dados */
        private Connection con = null;

        /** Usada para realizar as instrucoes SQL */
        public Statement stmt;

        /** Retorna os dados das tabelas do banco */
        public ResultSet rs;


        /**Usada para receber o endereco da base de dados*/
        private String endereco;

        /**Usada para receber o nome do usuario do banco */
        private String usuario;

        /**Usada para receber a senha do usuario do banco */
        private String senha;

        /** Esse metodo realiza a conexao com o banco, ele precisa de tres argumentos, o primeiro, recebe
         * o endereço do banco, o segundo recebe o nome do usuario e o terceiro recebe a senha do
         * banco de dados.
         *
         * EXP: "jdbc:postgresql://localhost:5432/projeto_01", "sa", "sa"
         *
         * **************************************************************************************************/

        public void Conectar(String strEnd, String strUsuario, String strSenha) {

            /** Recebendo o endereco,usuario e senha do usuario e repassando para a variavel global */
            endereco = "isicdbdev.intersicdigital.com.br";
            usuario = "negociafacil_adm";
            senha = strSenha;

            try {
                /** Pasando o nome do Driver do PostgreSQL */
                Class.forName("org.postgresql.Driver");

                /** Obtendo a conexao com o banco de dados*/
                con = DriverManager.getConnection(endereco, usuario, strSenha);

                /** Criando o Statement */
                stmt = con.createStatement();

                /** Retorna um erro caso nao encontre o driver, ou alguma informacao sobre o mesmo
                 * esteja errada */
            } catch (ClassNotFoundException cnfe) {
                JOptionPane.showMessageDialog(null, "Erro ao conectar o driver");
                cnfe.printStackTrace();

                /** Retorna um erro caso exista erro de query SQL */
            } catch (SQLException sqlex) {
                JOptionPane.showMessageDialog(null, "erro na query");
                sqlex.printStackTrace();

            }
        }

        /** Esse metodo quando invocado, realiza a desconexao com o banco */
        public void Desconectar() {

            try {
                con.close();

                /** Retorna um erro caso nao consiga desconectar */
            } catch (SQLException onConClose) {
                JOptionPane.showMessageDialog(null, "Erro ao desconectar o banco");
                onConClose.printStackTrace();
            }
        }
}

