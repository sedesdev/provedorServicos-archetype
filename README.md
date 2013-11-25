seam3-jboss7-archetype
======================

Resumo
------
Archetype para aplicativos provedores de Serviços no JBoss 7, conforme arquitetura definida segundo princípios do DDD

Características do projeto:
---------------------------
* JDBC
* JAX-RS 
* RestEasy Webservices 2.3.2

Obs.: É necessário JDK 1.6, Maven 3 e o JBoss 7.1.1.Final para executar.

Instalação
----------

Realize do download do archetype, clicando em `Download ZIP` e descompacte o arquivo no diretório de sua preferência.

Dentro da pasta criada, execute `mvn install` para instalar o archetype no repositório maven local

Crie um projeto
---------------

    mvn archetype:generate \
        -DarchetypeGroupId=br.jus.trese \
        -DarchetypeArtifactId=provedorServicos-archetype \
        -DarchetypeVersion=0.1-SNAPSHOT \
        -DarchetypeRepository=local
	

Para facilitar, copiar e colar:     

    mvn archetype:generate -DarchetypeGroupId=br.jus.trese -DarchetypeArtifactId=provedorServicos-archetype -DarchetypeVersion=0.1-SNAPSHOT -DarchetypeRepository=local

Ao ser perguntado sobre o artifactID, responda com o nome do domínio, tudo em minúsculo.

Na última pergunta, aperte ENTER

Então entre na pasta do projeto recém criado e digite:

    mvn replacer:replace



Importe o projeto no Eclipse
----------------------------

Vá em File > Import > General > Existing Projects into Workspace


Considerações
=============

O projeto recém criado contém a estrutura padrão para desenvolvimento de sistemas nas tecnologias acima descritas, servindo como um guia para iniciar a implementação propriamente dita.


Referências Externas
====================

Como instalar o MAVEN:  
* http://maven3tutorial.blogspot.com.br/2011/02/instalando-o-maven-no-seu-computador.html

Criando projetos no Maven:

* http://www.mkyong.com/maven/how-to-create-a-web-application-project-with-maven/
* http://maven.apache.org/guides/getting-started/maven-in-five-minutes.html

Criando Archetypes:

* http://www.luckyryan.com/2013/02/15/create-maven-archetype-from-existing-project/
* http://maven.apache.org/guides/mini/guide-creating-archetypes.html

Criando repositórios no Github:

* http://blog.rueedlinger.ch/2012/09/use-github-as-maven-remote-repository/