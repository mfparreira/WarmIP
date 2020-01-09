#language: pt

@temp
Funcionalidade: : Acessar contas de email para warmup
  Para que eu possa aquecer os email de warmup


  Contexto: Acessar email gmail
     Dado que eu acesso  email gmail

  Cenario: Verifico se tenho o email na caixa inbox

  Dado que acessei o email
  E verifico se tenho o email na caixa de entrada
  E eu clico no email com o assunto 'Especifico'
  E devo clicar no  link do email para abrir a pagina do Negocia Facil
  Então devo realizar a exclusão desse email recem aberto