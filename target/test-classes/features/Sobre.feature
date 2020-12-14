# language: pt

@tela_sobre
Funcionalidade: Acesso a tela Sobre

		Cenário: Verificar tela Sobre
    Dado o acesso do usuário para a lista de menu
    E clicar na opção about...
    Quando acessar a tela sobre, o usuário ler os dados
    Então verificará todos os dados da tela sobre
	