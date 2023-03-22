package simulador.view.teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import simulador.mode.usuarios.Usuariotb;
import simulador.view.Mensagens;

public class Derby_teste{
 private String framework = "embedded";
 private String driver = "org.apache.derby.jdbc.EmbeddedDriver";
 private String protocol = "jdbc:derby:";
 
 public void main(){
     new Derby_teste().go();
     System.out.println("SimpleApp finished");
 }
 @SuppressWarnings("unchecked")
void go(){
     System.out.println("SimpleApp starting in " + framework + " mode");
     loadDriver();
     Connection conn = null;
     @SuppressWarnings("rawtypes")
	ArrayList statements = new ArrayList(); 
     PreparedStatement psInsert = null;
     PreparedStatement psUpdate = null;
     Statement s = null;
     ResultSet rs = null;
     try
     {
         Properties props = new Properties(); 
         props.put("user", "root");
         props.put("password", "root");
         String dbName = "simuladordb"; // the name of the database
         conn = DriverManager.getConnection(protocol + dbName
                 + ";create=true; codeset=8859_1", props);
         System.out.println("Connected to and created database " + dbName);
         conn.setAutoCommit(false);
         
         s = conn.createStatement();
         
         //s.execute("create table location(num int, addr varchar(40))");
         
         //s.execute("create view v6 as SELECT count(ASSUNTO_PERGUNTA) AS count_dos_assuntos, estatisticastb.ASSUNTO_PERGUNTA FROM ASSUNTOTB ASSUNTOTB INNER JOIN estatisticastb estatisticastb ON ASSUNTOTB.ID_ASSUNTOTB = estatisticastb.ASSUNTO_PERGUNTA WHERE acertou = 0 GROUP BY ASSUNTO_PERGUNTA ORDER BY count_dos_assuntos DESC");
         //conn.commit();
         /*s.execute("CREATE TABLE autortb (id_AutorTB INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY "+ 
"(START WITH 1, INCREMENT BY 1) PRIMARY KEY ,"+
  "nome_AutorTB varchar(255) DEFAULT NULL ,"+
  "subestacao_AutorTB INTEGER DEFAULT NULL)");
         
         s.execute("CREATE TABLE subestacaotb " +
  "(id_SubestacaoTB INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) PRIMARY KEY ,"+
  "nomeid_SubestacaoTB varchar(255) DEFAULT NULL ,"+
  "controladoraid_SubestacaoTB varchar(255) DEFAULT NULL)");
         
         s.execute("CREATE TABLE assuntotb (id_AssuntoTB INTEGER NOT NULL GENERATED "+
         "ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) PRIMARY KEY ,"+
  "descricaoid_AssuntoTB varchar(1000) DEFAULT NULL)");
         
         s.execute("CREATE TABLE usuariostb ("+
  "idUsuariosTB INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1,"+ 
  "INCREMENT BY 1) PRIMARY KEY ,"+
  "usuarios varchar(500) DEFAULT NULL ,"+
  "senha varchar(500) DEFAULT NULL ,"+
  "tipo INTEGER DEFAULT NULL)");
         
         s.execute("CREATE TABLE figurastb ("+
  "id_figura INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1,"+   
  "INCREMENT BY 1) PRIMARY KEY ,"+
  "descricao varchar(1000)NOT NULL ,"+
  "figura BLOB NOT NULL)");
         
         s.execute("CREATE TABLE estatisticastb ("+
  "num_simulado INTEGER NOT NULL DEFAULT 0 ,"+
  "num_pergunta INTEGER NOT NULL ,"+
  "acertou INTEGER NOT NULL ,"+
  "assunto_pergunta INTEGER NOT NULL ,"+
  "codigo_estatisticastb BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START "+"" +
  "WITH 1, INCREMENT BY 1) PRIMARY KEY ,"+
  "resposta_correta char(1) NOT NULL ,"+
  "resposta_assinalada char(1) NOT NULL ,"+
  "id_usuario INTEGER NOT NULL)");
         
         s.execute("CREATE TABLE pontuacaotb ("+
         "id_PontuacaoTB INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY "+
         "(START WITH 1, INCREMENT BY 1) PRIMARY KEY ,"+
  "UsuariosTB_idUsuariosTB INTEGER NOT NULL CONSTRAINT PontuacaoTB_FKIndex1 REFERENCES UsuariosTB,"+
  "nome_PontuacaoTB varchar(500) DEFAULT NULL ,"+
  "acertos_PontuacaoTB double DEFAULT NULL ,"+
  "erros_PontuacaoTB double DEFAULT NULL ,"+
  "pontuacao_PontuacaoTB double DEFAULT NULL ,"+
  "id_simulado_estatisticastb bigint DEFAULT NULL)");
         /*
         s.execute("CREATE TABLE perguntastb (id_PerguntasTB INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) PRIMARY KEY ,"+
  "id_figuratb INTEGER DEFAULT NULL ,"+       
  "enunciado_PerguntasTB varchar(1000) NOT NULL ,"+
  "resposta_a_PerguntasTB varchar(1000) NOT NULL ,"+
  "resposta_b_PerguntasTB varchar(1000) NOT NULL ,"+
  "resposta_c_PerguntasTB varchar(1000) DEFAULT NULL ,"+
  "resposta_d_PerguntasTB varchar(1000) DEFAULT NULL ,"+
  "resposta_e_PerguntasTB varchar(1000) DEFAULT NULL ,"+
  "resposta_f_PerguntasTB varchar(1000) DEFAULT NULL ,"+
  "resposta_g_PerguntasTB varchar(1000) DEFAULT NULL ,"+
  "correta_PerguntasTB varchar(20) NOT NULL ,"+
  "AssuntoTBTB_id_AssuntoTB INTEGER NOT NULL CONSTRAINT Perguntas_FKIndex3 REFERENCES AutorTB ,"+
  "AutorTBTB_id_AutorTB INTEGER NOT NULL CONSTRAINT Perguntas_FKIndex1 REFERENCES SubestacaoTB ,"+
  "SubestacaoTBTB_id_SubestacaoTB INTEGER NOT NULL CONSTRAINT Perguntas_FKIndex2 REFERENCES AutorTB)"
  );/*
      
         /*
         s.execute("CREATE TABLE perguntastb (id_PerguntasTB INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) PRIMARY KEY ,"+
        		  "id_figuratb INTEGER DEFAULT NULL ,"+       
        		  "enunciado_PerguntasTB varchar(1000) NOT NULL ,"+
        		  "resposta_a_PerguntasTB varchar(1000) NOT NULL ,"+
        		  "resposta_b_PerguntasTB varchar(1000) NOT NULL ,"+
        		  "resposta_c_PerguntasTB varchar(1000) DEFAULT NULL ,"+
        		  "resposta_d_PerguntasTB varchar(1000) DEFAULT NULL ,"+
        		  "resposta_e_PerguntasTB varchar(1000) DEFAULT NULL ,"+
        		  "resposta_f_PerguntasTB varchar(1000) DEFAULT NULL ,"+
        		  "resposta_g_PerguntasTB varchar(1000) DEFAULT NULL ,"+
        		  "correta_PerguntasTB varchar(20) NOT NULL ,"+
        		  "AssuntoTBTB_id_AssuntoTB INTEGER ,"+
        		  "AutorTBTB_id_AutorTB INTEGER  ,"+
        		  "SubestacaoTBTB_id_SubestacaoTB INTEGER)"
        		  );
         
         */
         //s.execute("drop table perguntastb");
         //s.execute("ALTER TABLE perguntastb ALTER COLUMN id_PerguntasTB SET INCREMENT BY 1");
         
         //ALTER TABLE Employees ALTER COLUMN Salary DEFAULT 1000.0
        
         //System.out.println("Created table location");
         
         //s.execute("LOCK TABLES perguntastb");
         
         //s.execute("update pontuacaotb set certos_PontuacaoTB=certos_PontuacaoTB");
         
         //s.execute("ALTER TABLE pontuacaotb RENAME COLUMN certos_PontuacaoTB TO acertos_PontuacaoTB");
         //s.execute("drop table estatisticastb");
         //conn.commit();
         /*
         psInsert = conn.prepareStatement(
"INSERT INTO perguntastb (id_PerguntasTB, AssuntoTBTB_id_AssuntoTB, AutorTBTB_id_AutorTB, SubestacaoTBTB_id_SubestacaoTB, enunciado_PerguntasTB, resposta_a_PerguntasTB, resposta_b_PerguntasTB, resposta_c_PerguntasTB, "+

"resposta_d_PerguntasTB, resposta_e_PerguntasTB, resposta_f_PerguntasTB, resposta_g_PerguntasTB, correta_PerguntasTB, id_figuratb) VALUES "+
"(1,1,1,1,'Na caixa �PONTO DIGITAL� a indica��o �Falha de Aquisi��o� corresponde a:','Ponto fora de varredura;','Alarme n�o reconhecido no visor de alarmes;','A liga��o para adquirir o dado est� inoperante;','Indica��o de validade do "+

"ponto na UTR de origem.','','','','C',NULL),(2,1,1,1,'Deve ser observado antes do envio de um comando:','Confirmar a habilita��o de controle da UTR est� para �SAGE�:','Confirmar desativados �Num Lock� e �Caps Lock�;','Ambas as "+

"alternativas est�o corretas;','','','','','C',NULL),(3,1,1,1,'Deve ser dada aten��o permanente:','Terminal �n�o-prim�rio� com apenas os processos HIST, ALR e SERV iniciados;','Terminal �prim�rio� com apenas os processos HIST, ALR e "+

"SERV n�o iniciados;','Terminal �prim�rio� com apenas os processos HIST, ALR e SERV iniciados','Terminal �n�o-prim�rio� com apenas os processos HIST, ALR e SERV n�o iniciados ','','','','D',NULL),(4,1,1,1,'S�o condi��es que confirmam o "+

"SAGE operando 100 % normal ','Todos os rel�gios iguais e atualizados corretamente;','M�quina (s) n�o-prim�ria (s) com apenas os processos HIST e SERV n�o iniciados; ','Apenas um modem em comunica��o com a UTR;','Confirmar id�nticas "+

"nas v�rias m�quinas os valores de medidas, status de equipamentos, rela��o de pontos em alarme e lista de eventos.','As alternativas A, C e D est�o corretas','','','E',NULL),(5,1,1,1,'Na ocorr�ncia de alarme permanente de falha em "+

"processador PP ou PS da UTR MAP, � correto afirmar:','Tem car�ter de urg�ncia e a causa prov�vel � uma falha transit�ria num processador da UTR MAP;','Dever� ser resetada esta m�quina e comunicado o COSE;','Tem car�ter de advert�ncia "+

"e o Operador dever� aguardar a normaliza��o por at� 1 minuto, caso n�o normalize, passar a operar em modo convencional.','O Operador deve resetar a m�quina e, na persist�ncia da situa��o, acionar a manuten��o. ','Todas as alternativas "+

"est�o corretas;','Somente as alternativas A, B e D est�o corretas;','','F',NULL),(7,2,2,5,'O que �  controle de tens�o?','Conjunto de a��es para manuten��o dos n�veis de tens�o dentro de par�metros que atendam aos requisitos de "+

"qualidade e confiabilidade operativa do sistema.','Monitora��o de grandezas ou do estado de equipamentos e linhas de transmiss�o visando a  ado��o de medidas para obten��o de valores ou estados desejados.','Estado do sistema "+

"caracterizado pela sua topologia e par�metros el�tricos em tempo real.','A��o de desenergiza��o manual ou autom�tica de um equipamento.','Execu��o de comando efetuado a dist�ncia atrav�s do sistema digital, do rel� de prote��o ou do "+

"painel convencional.','','','A',NULL),(8,4,4,2,'Quais s�o as atribui��es do COSE?','Supervisionar, coordenar e controlar as instala��es n�o integrantes da Rede de Opera��o, em conjunto com as demais empresas envolvidas;','Coordenar e "+

"controlar as instala��es n�o integrantes da Rede B�sica, em conjunto com as demais empresas envolvidas;','Orientar, as instala��es  integrantes da Rede de Opera��o, em conjunto com as demais empresas envolvidas;','Observar,  e "+

"controlar as instala��es n�o integrantes da Rede B�sica, em conjunto com as demais empresas envolvidas;','Interagir, e controlar as instala��es  integrantes da Rede de Opera��o.','','','A',NULL),(10,6,6,5,'De acordo com a Norma de "+

"Opera��o de Redes � Comunica��o Verbal, a comunica��o verbal na opera��o em tempo real deve ser precisa, formal, padronizada, clara e objetiva. Ela determina tamb�m que uma seq��ncia padronizada deve ser observada a fim de garantir o "+

"perfeito entendimento das informa��es.\r\n\r\nEnumere as alternativas abaixo de acordo com a seq��ncia padr�o e em seguida escolha a resposta correta dentre as op��es: \r\n\r\n(  ) Encerramento\r\n(  ) Transmiss�o de mensagem pelo "+

"emissor;\r\n(  ) Confirma��o, pelo transmissor, do entendimento da mensagem;\r\n(  ) Identifica��o dos interlocutores: local (Subesta��o, COSE ou Agente) e nome do receptor/transmissor;\r\n(  ) Repeti��o da mensagem recebida pelo "+

"receptor;\r\n','4, 3, 2, 5, 1;','1, 2, 5, 4, 3;','5, 2, 4, 1, 3;','3, 4, 5, 2, 1;','2, 5, 4, 3, 1.','','','C',NULL),(11,7,7,5,'Com rela��o a periodicidade das inspe��es nas instala��es sob responsabilidade da ELETROSUL, � correto "+

"afirmar:','Em Controladoras - diariamente, com 1 (uma) inspe��o di�ria, podendo esta ser dividida em 3 partes (uma por turno);  ','Em Controladas com opera��o local - diariamente, com 1 (uma) inspe��o di�ria, em dias �teis;','Em "+

"Controladas sem opera��o local - quinzenalmente, exceto nas Subesta��es Florian�polis, Desterro, Joinville e Caxias 5, onde a inspe��o dever� ocorrer semanalmente;  ','As alternativas a, b, c e d, est�o corretas;','Nenhumas das "+

"alternativas est�o corretas.','','','D',NULL),(12,8,8,5,'Uma das situa��es em que pode ser emitido um �nico RRO, �?','Ocorr�ncias simult�neas em instala��es diversas.','Ocorr�ncias simult�neas em uma mesma instala��o.','Ocorr�ncias em "+

"um mesmo turno.','Ocorr�ncias em um mesmo dia.','Nenhuma das anteriores.','','','B',NULL),(13,9,9,1,'Com rela��o �s normas de Seguran�a em Instala��es, verifique as afirma��es abaixo quanto a verdadeiro ou falso e depois assinale a "+

"alternativa correta:\r\n\r\n(   ) -Pr�ximo a instala��es com tens�o, o transporte de escadas ou objetos alongados pode ser feito portando-os na posi��o horizontal ou vertical.\r\n(   ) -N�o � permitido o uso de equipamentos de limpeza "+

"que utilizem �gua sob press�o dentro da zona controlada em �reas energizadas.\r\n(   ) -� proibido o uso de guarda-chuvas, escadas e trenas met�licas ou de pano com alma de a�o, em �reas energizadas, por�m o uso de adere�os met�licos, "+

"como rel�gios, pulseiras, etc. � permitido.\r\n(   ) -A dist�ncia m�nima necess�ria para execu��o de servi�o em subesta��es na classe de tens�o de 230 kV � 3,00 metros.\r\n(   ) -A dist�ncia m�nima necess�ria para execu��o de servi�o "+

"em subesta��es na classe de tens�o de 500 kV � 3,40 metros.\r\n','V, V, V, V, V','F, F, F, F, F','V, V, F, F, F','F, V, F, F, V','','','','D',NULL),(14,10,10,5,'Na execu��o de um PL qual a sequ�ncia correta dos procedimentos em "+

"rela��o aos atestados. ','Confirma��o pr�via,  inspe��o da �rea,  atestado isolamento, recebimento da �rea, devolu��o da �rea.  ','Atestado isolamento, inspe��o da �rea, recebimento da �rea, confirma��o pr�via, devolu��o da �rea.     "+

"Atestado isolamento, inspe��o da �rea, recebimento da �rea, confirma��o pr�via, devolu��o da �rea.     Atestado isolamento, inspe��o da �rea, recebimento da �rea, confirma��o pr�via, devolu��o da �rea.     ','Confirma��o pr�via, "+

"isolamento da �rea, recebimento da �rea, devolu��o da �rea, inspe��o da �rea.','Inspe��o da �rea, recebimento da �rea, confirma��o pr�via, isolamento da �rea, devolu��o da �rea. ','Atestado isolamento, inspe��o da �rea, confirma��o "+

"pr�via, devolu��o da �rea, recebimento da �rea.','','','C',NULL),(15,11,11,5,'Os servi�os executados por empreiteiras ou por empregados da empresa na Subesta��o, ter�o como respons�vel pela seguran�a:','Respons�vel do DMS','O Chefe de "+

"Setor e o Chefe de Turno obrigatoriamente','O Dono da empreiteira ','A Divis�o da Obra executora dos servi�os','','','','D',NULL),(16,12,12,4,'Qual deve ser a  posi��o da chave 43 T para que o DJ 782 (ATF 1 � CMO) fique com o seu "+

"comando de fechamento remoto bloqueado ?\r\n\r\n','Posi��o normal','Posi��o intermediaria','Posi��o transferida','Posi��o normal e transferida.','Posi��o intermediaria e transferida.','','','C',NULL),(18,12,12,4,'Se o DJ 782 (ATF 1) "+

"estiver com a chave 43 T na posi��o INTERMEDI�RIA, em qual ou quais disjuntores atuar� a prote��o?\r\n\r\n','Somente no DJ 782','Somente no DJ 772','Fica momentaneamente sem prote��o','Nos DJ�s 772 e 782','Nos DJ 782 e "+

"792','','','D',NULL),(19,12,12,4,'Quais os tipos de comandos que possuem as chaves seccionadoras da SE CMO?\r\n\r\n','Comando el�trico remoto convencional e digital','Apenas comando mec�nico','Comando mec�nico e el�trico "+

"local','Comando el�trico local e remoto digital','As alternativas A e C est�o corretas','','','E',NULL),(20,12,2,1,'Quais s�o as condi��es de intertravamento que devem estar satisfeitas para efetuar comando na CS 1067T da LT IVP1 na "+

"SE LON?','LT IVP 1 sem tens�o e CS 1067 aberta.','LT IVP 1 sem tens�o e CS 1061 aberta','LT IVP 1 sem tens�o e CS 1063 aberta.','CS�s 1061 e 1067 abertas.','Barra B 525 KV da SE LON.desenergizada. e aterrada.','','','A',NULL),"+

"(25,12,2,1,'Qual a finalidade do dispositivo CK instalado na CS 1047T da LT IVP2  na SE LON?','Na abertura da CS a l�mina principal abre primeiro e, antes da haste auxiliar abrir, o circuito � aberto na c�mara de SF6.','O arco da "+

"corrente induzida na linha � extinto no momento do aterramento numa c�mara com SF6.','Suprimir a indu��o de corrente que � consider�vel onde existem linhas paralelas para n�o danificar a CS de aterramento.','No fechamento da CS a "+

"haste auxiliar faz o primeiro contato, fechando o arco na camara de SF6.','Todas as alternativas est�o corretas.','','','E',NULL),(27,12,2,1,'Quais alarmes devem sinalizar no visor de alarmes do SAGE quando o rel� K69 que faz a "+

"supervis�o da alimenta��o 480VCA das motobombas do DJ 1042 (AREVA) da LT IVP2 na SE LON,  ficar inoperante (queimado)?\r\n\r\n','DJ 1042 bloqueado abertura e fechamento.','DJ 1042  falta alimenta��o CA e CC.','DJ 1042 bloqueado "+

"fechamento e defeito circuito hidr�ulico.','DJ 1042 baixo n�vel �leo e baixa press�o SF6.','DJ 1042 excesso opera��o motobomba e rel� t�rmico operado.','','','C',NULL),(28,12,13,2,'O comando convencional dos disjuntores a partir da "+

"mesa de comando funciona em:','S�rie com o sistema digital via SAGE;','Paralelo com o sistema digital via SAGE;','S�rie e paralelo com o sistema digital via SAGE;','Oposi��o ao sistema digital via SAGE;','Nenhuma das respostas "+

"anteriores.','','','B',NULL),(29,12,13,2,'O sincronismo dos disjuntores da subesta��o Ivaipor� poder� ser feito digitalmente, atrav�s do sistema digital de telecontrole na subesta��o Ivaipor� ou na subesta��o controladora, usando para "+

"isso:\r\n\r\n','l�gica implementada nas UAC�s AM 1703 para os disjuntores DJ 1002 e DJ 1042;','A l�gica implementada nos rel�s de prote��o SEL 451 para os disjuntores DJ 1070 e DJ 1072;','rel� de sincronismo 7VK512 Siemens para os "+

"demais disjuntores;','O sincronosc�pio anexo ao painel de controle do Bay 1;','As alternativas A, B e C est�o corretas.  ','','','E',NULL),(30,12,13,2,'Com rela��o ao comando el�trico convencional das Chaves Seccionadoras:','Todas as "+

"Chaves Seccionadoras da SE-IVP podem ser operadas;','Somente as Chaves Seccionadoras Gould-ITE podem ser operadas;','Somente as Chaves Seccionadoras Lorenzetti podem ser operadas;','Somente as Chaves Seccionadoras da LT-LON 2 n�o "+

"possuem esse tipo de comando;','Nenhuma Chave Seccionadora da SE-IVP possui esse tipo de comando.','','','D',NULL),(31,12,3,4,'Com rela��o a chave 43T do DJ 782 do TF1 na SE Campo Mour�o podemos afirmar que:\r\n\r\n','Com a chave 43T "+

"seletada para NORMAL, a prote��o atuar� nas barras P e T.','Com a chave 43T seletada para TRANSFERIDO, a prote��o atuar� provocando o     desligamento das LTSOS1 e LTSOS2 para evitar sobrecarga no TF1. ','Com a chave 43T seletada para "+

"INTERMEDI�RIO, a prote��o atuar� nas LIAPA e  LIMGA para que n�o haja uma sobretens�o na subesta��o da COPEL.','Com a chave 43T seletada para TRANSFERIDO, caso haja algum defeito no TF1 teremos uma desligamento Geral da SE Campo "+

"Mour�o.','Com a chave 43T seletada para INTERMEDI�RIO, a prote��o que atua sobre o DJ 782 tamb�m � enviada ao DJ 772 (TRANSFER�NCIA).  ','','','E',NULL),(32,12,14,4,'Sobre os disjuntores da SECMO. ','Os Dj�s Magrini foram modificados "+

"para que os rel�s XE e XE� d�em trip por baixa press�o de g�s e ar e bloqueiem o fechamento.','Os Dj�s Magrini apenas bloqueiam o fechamento por baixa press�o de g�s.','Os Dj�s Magrini apenas bloqueiam o fechamento por baixa press�o "+

"de ar.','Todas as alternativas est�o corretas.','Todas as alternativas est�o incorretas.','','','A',NULL),(33,12,14,4,'Quanto ao comando do Disjuntor.','disjuntor n�o possui comandos manuais.','O disjuntor possui comando el�trico "+

"local de abertura e fechamento; comando el�trico remoto via painel de controle para abertura e fechamento; comando el�trico remoto via sistema digital para abertura e fechamento.','O comando manual do disjuntor est� fora de opera��o. "+

"','Todas alternativas est�o corretas.','Todas alternativas est�o incorretas.','','','B',NULL),(34,12,14,4,'Quais os tipos de comando das seccionadoras?','Comando mec�nico.','Comando el�trico local. ','Comando el�trico remoto, via "+

"painel de controle e/ou digital, para abertura e fechamento.','Todas alternativas est�o corretas.','Todas alternativas est�o incorretas.','','','D',NULL),(35,12,14,4,'Sobre as alimenta��es  auxiliares das seccionadoras.','As "+

"alimenta��es essenciais e complementares, s�o fornecidas pelo sistema de CA.','As alimenta��es essenciais compreendem  cc para os circuitos de comando e intertravamento e Ca para os motores. ','As alimenta��es complementares "+

"compreendem aquelas destinadas aos circuitos de comando da CS.','Todas alternativas est�o corretas.','Todas alternativas est�o incorretas. ','','','B',NULL),(36,12,15,4,'Quais os tipos de comando podem ser efetuados nos disjuntores "+

"230 Kv da SECMO','Apenas comando local e via SAGE.','Apenas comando via SAGE','Apenas comando local e remoto via painel de controle.',' Comando local, remoto via painel e remoto via SAGE. ','N.D.A','','','D',NULL),(37,12,15,4,'Quais "+

"os procedimentos para efetuar um comando mec�nico na CS Brush Power 230 kv da SECMO.','Seletar a chave local / remoto para posi��o desligada, inserir a manivela e girar no  sentido desejado.','Inserir a manivela e girar no sentido "+

"desejado.','N�o possui comando mec�nico.','Seleta a chave para posi��o desejada e d� comando de partida no motor.','N.D.A','','','A',NULL),(38,12,15,4,'Qual � o rel� que faz a supervis�o do sincronismo para o fechamento do DJ, via "+

"SAGE. ','Rel� 85','Rel� 27','Rel� 25','Rel� 51','Rel�21','','','C',NULL),(39,12,15,4,'Qual � a fun��o da chave 43T, no Bay do ATF 01','Desligar o comando remoto do DJ 782','Transferir a prote��o do DJ 782 para o DJ 772 do m�dulo de "+

"transfer�ncia.','Efetuar a sele��o local / remoto do DJ 782.','Na posi��o transferida, mant�m a prote��o nos DJ�s 772 e 782. ','N.D.A','','','B',NULL),(40,12,15,4,'Qual � a finalidade da l�mpada amarela referente as chaves "+

"seccionadoras, localizadas no painel de controle da SECMO.','Sinaliza CS em transito.','Sinaliza falta CC na CS.','Sinaliza CS fechado.','Sinaliza falta de CA na CS.','Sinaliza intertravamento satisfeito.','','','E',NULL),"+

"(41,12,15,4,'Caso n�o consiga fechar um DJ, via SAGE, devido a falha no rel� de sincronismo, qual o procedimento dever� ser efetuado para  fechar o DJ?\n\n','Resetar o rel� 25 no SAGE.','Aguardar 3 minutos e efetuar nova "+

"tentativa.','Desativar o rel� 25 manualmente, diretamente no painel de controle, pois n�o existe a possibilidade pelo telecontrole.','O sincronismo via SAGE independe do rel� 25.','N.D.A','','','C',NULL),(42,12,15,4,'As CS�s finais 1 "+

"(barra) e finais 3 ( linhas) s�o intertravadas com quais equipamentos.','As CS finais 1, intertrava-se com o respectivo DJ e a CS de By pass.','As CS�s final 3, intertrava-se com o respectivo DJ e a CS de By pass.','As CS�s final 1 e "+

"3, n�o possui intertravamento, podendo ser manobradas a qualquer momento.','AS CS�s final 1 e 3, s�o intertravadas apenas com seu respectivo DJ.','N.D.A','','','D',NULL),(43,12,7,4,'As chaves secionadoras possuem os seguintes tipos de "+

"comando:','Comando Mec�nico;','Comando El�trico Local;','Comando El�trico  Remoto, via painel de controle, para abertura e fechamento;','Comando El�trico Remoto via sistema digital, para abertura e fechamento;','Todas as alternativas "+

"acima est�o corretas  ','','','E',NULL),(44,1,7,4,'Em conformidade com o circuito de intertravamento dos DJs, a opera��o dos rel�s XE e XE� implicam no(a):','Impedimento de acionamento das CSs isoladoras do DJ Magrini em "+

"Quest�o;','Bloqueio da abertura do DJ relacionado;','Atua��o do esquema de Falha Disjuntor da SE CMO;','Trip por baixa press�o de g�s e ar  e bloqueia o fechamento do DJ envolvido;','Nenhuma das alternativas acima.','','','D',NULL),"+

"(45,12,7,4,'Os DJ�s 1050 e 1052 na SE IVP, s�o do fabricante VATECH, tipo FA4R-40,  e de acordo com o Manual de Instala��o, com rela��o ao seu mecanismo de opera��o hidr�ulico  Press�es SF6, � correto afirmar:','Nominal: 7,0 Bar,  -  "+

"1� est�gio: 7,2 Bar � Alarme - 2� est�gio: 8,0 Bar � TRIP/Bloqueio fechamento;','Nominal: 7,2 Bar,  -  1� est�gio: 8,2 Bar � Alarme - 2� est�gio: 7,0 Bar � TRIP/Bloqueio fechamento;','Nominal: 8,0 Bar,  -  1� est�gio: 7,2 Bar � Alarme "+

"- 2� est�gio: 7,0 Bar � TRIP/Bloqueio fechamento.','Nominal: 5,0 Bar,  -  1� est�gio: 7,2 Bar � Alarme - 2� est�gio: 9,0 Bar � TRIP/Bloqueio fechamento;','Nenhuma das alternativas acima.','','','C',NULL),(47,12,7,4,'Os DJ�s 1050 e "+

"1052 na SE IVP, s�o do fabricante VATECH, tipo FA4R-40,  e de acordo com o Manual de Instala��o, com rela��o ao seu mecanismo de opera��o hidr�ulico  Press�es do �leo, � correto afirmar:\n\n','Nominal: 326 Bar - 1� est�gio: 264 Bar � "+

"Alarme/Bloqueio fechamento - 2� est�gio: 250 Bar � Trip/Bloqueio fechamento;','Nominal: 250 Bar - 1� est�gio: 326 Bar � Alarme/Bloqueio fechamento - 2� est�gio: 264 Bar � Trip/Bloqueio fechamento;','Nominal: 264 Bar - 1� est�gio: 250 "+

"Bar � Alarme/Bloqueio fechamento - 2� est�gio: 264 Bar � Trip/Bloqueio fechamento;','Nominal: 326 Bar - 1� est�gio: 264 Bar � Alarme/Bloqueio fechamento - 2� est�gio: 250 Bar � Trip/Bloqueio fechamento;','Todas as alternativas acima "+

"est�o corretas ','','','A',NULL),(48,13,8,1,'O transformador TF-3 da SE LON, possui um sistema de comuta��o sob carga com deriva��es (tap,s). Quantas s�o as deriva��ese e como s�o numeradas?','19 deriva��es, numeradas de 9R a 9L, "+

"passando pelo tap central, denominado N','19 deriva��es, numeradas de 9R a 9L, e n�o possui tap central','18 deriva��es, numeradas de 9R a 9L','18 deriva��es, numeradas de 9R a 9L, passando pelo tap central','N�o possui "+

"deriva��es','','','A',NULL),(49,13,11,1,'O transformador TF-4 da SE LON, possui um sistema de comuta��o sob carga com deriva��es (tap�s). Quantas s�o as deriva��es e como s�o numeradas?','19 deriva��es, numeradas de 1 a 19, e n�o "+

"possui tap central','19 deriva��es, numeradas de 1 a 19, passando pelo tap central, denominado 10','18 deriva��es, numeradas de 1 a 18','18 deriva��es, numeradas de 1 a 18, passando pelo tap central','N�o possui deriva��es  "+

"','','','B',NULL),(50,14,11,4,'A alimenta��o principal dos Servi�os Auxiliares da SE CMO � feita atrav�s','Do terce�rio do trafo da Copel em 13,8kV','Da linha de distribui��o em 34,5kV','De ambos os trafos em paralelo','De qualquer "+

"fonte por conveni�ncia do operador','','','','A',NULL),(51,14,11,4,'As barras de 460 Vca dos servi�os auxiliares da SE CMO disp�em de duas fontes de alimenta��o independentes; qual a filosofia operacional das barras, em condi��es "+

"normais?','As barras operam separadas, sendo a barra 1 alimentada pela fonte principal e a barra 2 alimentada pela fonte alternativa;','As barras operam interligadas ambas alimentadas pela fonte principal;','As barras operam "+

"interligadas alimentadas simultaneamente por ambas as fontes visando aumentar a confiabilidade;','A filosofia operacional das barras 460Vca s�o definidas pelo chefe de turno podendo ser alterada a crit�rio do "+

"mesmo.','','','','B',NULL),(52,14,13,2,'Quais os n�veis de tens�o CA dos servi�os auxiliares da SE-IVP?','34,5kV/13,8kV/480V/220V/127V','125V/48V','380V/110V','525kV','Nenhum dos anteriores.','','','A',NULL),(53,3,3,5,'Em instala��es "+

"compartilhadas onde a opera��o do disjuntor de transfer�ncia � realizada pela Eletrosul, o COSE ser� coordenado pelo ONS nas manobras de transfer�ncia, recomposi��o, necessidades de abertura do disjuntor e retorno � opera��o normal "+

"dos m�dulos de terceiros que necessitarem utilizar o disjuntor de transfer�ncia. Assinale a alternativa correta.','O operador da controladora dever� fazer a coordena��o junto aos demais agentes envolvidos;','Os agentes de outras "+

"empresas far�o contato com o operador da controladora solicitando o fechamento do DJ de transfer�ncia;','O operador verificando a demora da comunica��o do COSE, deve iniciar imediatamente as manobras para agilizar os trabalhos;','Os "+

"agentes do ONS far�o contato imediatamente com a operador local solicitanto rapidez, seguran�a e efici�ncia nas manobras;  ','O COSE coordenar� a opera��o da controladora e informar� ao operador da SE para o fechamento do DJ de "+

"transfer�ncia.  ','','','E',NULL),(55,12,15,4,'A alimenta��o em 220 vca, para os DJ�s 230 kv, possui a seguinte finalidade.\n\n','Alimentar os compressores dos DJ�s.','Alimentar a bomba de �leo.','Alimentar a resist�ncia de "+

"aquecimento.','Alimentar circuito de abertura e fechamento.','N.D.A','','','C',NULL),(56,5,5,5,'De que forma � o Relacionamento do COSE com as SE�s Controladas?\nAssinale a alternativa correta:\n\n','De forma direta sempre que "+

"necessitar.','De forma indireta, atrav�s da Controladora mesmo estando a SE Controlada em local.','De forma direta, quando a Controlada estiver em Local.','','','','','C',NULL),(57,14,13,2,'Quais s�o as barras essenciais de 480V da "+

"SE-IVP?','Barras I, II, III, IV e V;','Barras I, II e III;','Barras III, IV e V;','Barras I e II;','A SE-IVP n�o possui barras essenciais.','','','D',NULL),(58,14,13,2,'No setor de 125 Vcc as l�mpadas de defeito (Terra Positivo ou "+

"Terra Negativo) operam com metade da luminosidade, quando houver um defeito:','Ambas se apagar�o;','Uma apagar-se-� e a outra aumentar� sua luminosidade;','Ambas aumentar�o a luminosidade;','Uma permanece com metade da luminosidade e "+

"a outra fica piscando;','Ambas ficam piscando.','','','B',NULL),(59,14,13,2,'A ilumina��o de emerg�ncia da SE-IVP n�o contempla:','A sala de controle;','A casa do diesel;','A casa de bombas;','Os corredores da casa de controle;','O "+

"p�tio de 525kV da SE.','','','E',NULL),(60,14,4,2,'Quantos   setores de  125Vcc e 48Vcc que existem na subesta��o de Ivaipor�?','Um setor  de de 125cc apenas.','H� dois setores, um 125 Vcc e um de 48 Vcc.','Um setor  de de "+

"48cc.','Dois setores de de 125cc.','Dois de setores de 48Vcc.','','','B',NULL),(61,14,4,2,'Como operam as Barras dos  Setores  de 48Vcc e 125Vcc na subesta��o de  Ivaipor�?','Barras em s�rie','Barras Interligadas','Barras  "+

"Separadas','Barras em Paralelo','Barras soldadas','','','C',NULL),(62,14,14,4,'Qual a finalidade do Setor de CC, da SECMO?','Alimentar os equipamentos de comunica��o.','Alimentar os dispositivos de prote��o. ','O CC � utiilizado "+

"somente na falta de CA.','Alimentar os dispositivos de prote��o, alarmes, comunica��o, sinaliza��o e sistema DETRE. Na eventual falta de CA, a ilumina��o de emerg�ncia da casa de controle e casa do gerador.','Todas alternativas est�o "+

"corretas. ','','','D',NULL),(63,14,14,4,'Em rela��o aos setores de CC, da SECMO.','H� dois setores, um de 12 Vcc e outro de 125Vcc.','H� tr�s setores: 12Vcc, 48Vcc e 125Vcc. ','H� dois setores, um de 125 Vcc e outro de 48 Vcc.','O "+

"setor de CC � composto apenas pelo 125 Vcc.','Todas as alternativas est�o incorretas. ','','','C',NULL),(64,14,14,4,'Para os setores de CC, da SECMO.','Ambos os setores de 48 Vcc e 125 Vcc operam id�nticos com rela��o ao revezamento "+

"nas barras de carga e de opera��o. Quando um conjunto ( carregador/bateria), estiver alimentando a barra de opera��o o outro conjunto estar� alimentando a barra de carga.','O barramento de carga em nenhum instante dever� ficar "+

"desenergizado, por menor que seja o intervalo de tempo. ','O barramento de 12 Vcc n�o poder� ficar desenergizado. ','Os setores de 12 Vcc, 48 Vcc e 125 Vcc, operam id�nticos com rela��o ao revezamento nas barras de carga e "+

"opera��o.','Todas alternativas est�o corretas. ','','','A',NULL),(65,14,14,4,'No setor de 125 Vcc da SECMO, como � feito o intertravamento entre os dj�s de alimenta��o da barra de opera��o e de carga?','E feito eletricamente.','N�o "+

"existe intertravamento. ','S� � feito mecanicamente.','Atrav�s do sistema eletromec�nico.','Todas alternativas est�o corretas. ','','','C',NULL),(66,14,10,1,'No setor de 480 Vca , quando usarmos a fonte alternativa GGDE ( DJ 52E ), "+

"quais DJ�s dever�o estar abertos para satisfazer o intertravamento mec�nico (chaves) e  isolar diretamente a Barra essencial (Barra II ) ?','52 A1  e  52 C1 ','52 A1  e  52 E','52 C1 e  52 E','52 B  e  52 D','52 E , 52 A1 e 52 "+

"C1','','','D',NULL),(67,14,10,1,'Qual o n�vel de tens�o na entrada dos Carregadores de 125Vcc na SE LON?','13.8 Kv','127 Vca','480 Vca','34,5 Kv','220 Vca','','','C',NULL),(68,14,6,4,'Em rela��o aos Servi�os Auxiliares da SE CMO e "+

"segundo o Manual de Instala��o espec�fico desta, qual a finalidade do Grupo Gerador Diesel de Emerg�ncia (G.G.D.E.)?\n\n','O grupo gerador de emerg�ncia tem por finalidade ser a fonte principal dos Servi�os Auxiliares da SE CMO em "+

"460Vca mesmo quando as alimenta��es de 13,8Kv (TF3)  e 34,5Kv (Copel) estiverem dispon�veis;','O G.G.D.E. tem por finalidade suprir os servi�os auxiliares da barra II, tens�o 460 Vca, na falta de alimenta��o principal e alternativa, "+

"juntas.','O G.G.D.E. tem por finalidade alimentar exclusivamente o sistema de ar condicionado da SE CMO;','O G.G.D.E. tem por finalidade �nica a de alimentar o sistema de inform�tica da SE CMO.','','','','B',NULL),(69,14,6,4,'Em "+

"rela��o aos Servi�os Auxiliares da SE CMO e segundo o Manual de Instala��o espec�fico desta, qual a finalidade do setor de 460vca?','O setor de 460 Vca tem por finalidade �nica e exclusiva a de alimentar a ilumina��o do p�tio da SE "+

"CMO;','O setor de 460 Vca tem por finalidade �nica e exclusiva a de alimentar a central de ar comprimido da SE CMO;','O setor de 460 Vca tem por finalidade �nica e exclusiva a de alimentar os sistemas de inform�tica e de ar "+

"condicionado da SE CMO;','O setor de 460 Vca tem por finalidade alimentar os dispositivos e equipamentos de controle, ilumina��o, compressores de ar, desumidificadores, condicionadores de ar, bem como parte dos setores de corrente "+

"cont�nua, atrav�s dos retificadores. ','','','','D',NULL),(70,15,13,2,'O rel� TREETECH TM1 instalado no arm�rio individual de cada fase do reator RE 1 � o equipamento utilizado para medi��o de:\n\n','Temperatura do enrolamento e do "+

"�leo.','Temperatura somente do �leo.','Temperatura somente do enrolamento.','Corrente de entrada do reator.','Corrente de neutro do reator.','','','A',NULL),(71,15,13,2,'O sistema de prote��o contra inc�ndio dos reatores RE 1 "+

"utiliza:','G�s carb�nico.','Espuma.','�gua nebulizada.','Ar comprimido.','P� qu�mico.','','','C',NULL),(72,15,13,2,'O sistema de resfriamento do banco de reatores � do tipo:','�leo natural.','�gua natural.','�leo for�ado.','�gua "+

"for�ada.','�leo Natural e ar natural (ONAN).','','','E',NULL),(73,15,13,2,'A pot�ncia de cada unidade monof�sica do reator RE 1 � de:','33,33 VAr','33,33 kVAr','33,33 MVAr','33,33 GVAr','33,33 MW','','','C',NULL),(74,15,1,1,'Qual a "+

"finalidade dos reatores limitadores de corrente (SR-01 e SR-02) aplicados junto aos ATF�s III e IV da subesta��o Londrina ?','Permitir usar na prote��o dos terci�rios dos ATF�s III e IV dj�s com n�veis menores de interrup��o de "+

"corrente;','Propiciar que, em caso de �falha-�-terra� no terci�rio de um dos ATF�s, rel� 64-T atue desenergizando o ATF envolvido;  ','Propiciar que, em caso de �falha-�-terra� no terci�rio de um dos ATF�s, rel� 64-T atue alarmando na "+

"sala de comando;','Fornecer refer�ncia de corrente para o rel� 87-T.   ','','','','A',NULL),(75,15,9,2,'Com rela��o � opera��o de Reatores na SE IVP, verifique as afirma��es abaixo quanto a verdadeiro ou falso e depois assinale a "+

"alternativa correta:\n\n(   ) O banco � composto por 3 unidades monof�sicas, de 525 kV. Uma unidade reserva que pode substituir qualquer uma das fases em caso de problema.\n(   ) O sistema pode ser submetido a uma tens�o de at� 600 kV "+

"em opera��o cont�nua.\n(   ) O supervis�rio SAGE n�o disp�e de medi��o instant�nea de grandezas, como corrente e tens�o, para o banco de reatores.\n(   ) O equipamento utilizado para a medi��o de temperatura do enrolamento e do �leo "+

"de cada fase do RE1 � o TREETECH TM1, instalado no arm�rio individual de cada fase do reator.\n','V, V, F, V','V, F, F, F','V, F, F, F','F, F, F, F','','','','A',NULL),(76,15,5,2,'Qual composi��o do Banco de Reator de IVP?','� "+

"composto por tr�s unidades monof�sicas, com uma unidade reserva.','� composto por uma Unidade Trif�sica.','C-	� composto por tr�s unidades monof�sicas, sem unidade reserva.','A SE IVP n�o possui banco de "+

"Reatores.','','','','A',NULL),(77,15,5,2,'Quanto ao resfriamento do banco de reator, feita pelos Radiadores instalados nas laterais dos mesmos, pode afirmar que:\n\n','� feita apenas por ventila��o for�ada.','� feita por ventila��o "+

"for�ada e circula��o de �leo for�ada.','A circula��o do �leo � tipo convec��o natural.','','','','','C',NULL),(78,1,13,2,'Qual o esquema especial de prote��o e controle que n�o est� contemplado pela SE-IVP?','Abertura autom�tica das "+

"chaves seccionadoras isoladoras dos disjuntores;','Abertura autom�tica das chaves seccionadoras isoladoras dos disjuntores;','Corte gera��o por perda de transformador 765/525kV; Interliga��o Furnas � Retardo abertura DJ�s 525kV;','LT "+

"Ivaipor� � Londrina 1 � Transfer�ncia de disparo;','N�o existem esquemas especiais nas SE-IVP.','','','A',NULL),(79,16,6,2,'De acordo com o Manual de Instala��es - Esquemas Especiais da SE IVP, marque a segunda coluna de acordo com a "+

"primeira e escolha a alternativa que cont�m a seq��ncia correta.\n\nColuna 1\n1.Interliga��o com Furnas � Retardo na abertura dos DJ�s de 525Kv;\n2.Corte de Gera��o por perda do Transformador 765/525 Kv;\n3.LT�s Ivaipor� � Londrina "+

"Circuitos 1 e 2 � Transfer�ncia de Disparo.\n\nColuna 2\n(  ) Esquema que envia sinal de disparo para os disjuntores da LT IVP-SSA1 e canal C ao terminal remoto desta quando ocorre sobrecarga de 50% nos Transformadores 1 ou 2 de "+

"765/525 kV- FURNAS.\n(   ) Retardar em 45 ms a abertura dos disjuntores do lado de 525 kV dos Transformadores 1 e 2 765/525 kV, garantindo que a abertura destes ocorra ap�s a abertura dos disjuntores de 765 kV de FURNAS..\n(   ) Toda "+

"abertura tripolar dos disjuntores das LTs IVP-LON 1 e 2 de 525 kV, no terminal de Ivaipor� ou Londrina, enviar� sinal de disparo para abertura do terminal remoto.\n','3, 2, 1;','1, 3, 2;','2, 1, 3;','2, 3, 1;','1, 2, "+

"3.','','','C',NULL),(80,1,1,1,'Qual a finalidade do Esquema Especial instalado na LT Ivp II 525 kV da subesta��o Londrina ?','Eliminar as tens�es elevadas, em regime, quando da abertura da LT em um dos terminais, permanecendo a linha "+

"energizada a vazio pelo outro terminal.','Eliminar res�duos de MVAr em valores altos na LT. ','Evitar desarme da LT Ivp I 525 kV, por sobrecarga.Assinale a alternativa correta:  ','','','','','A',NULL),(81,16,13,5,'A finalidade da "+

"prote��o contra falha de disjuntor �:\n\n','Provocar a abertura do disjuntor falhado.','Garantir a circula��o de corrente pelo disjuntor falhado.','Anular a prote��o intr�nseca do disjuntor falhado possibilitando sua "+

"manobra.','Provocar a abertura dos disjuntores adjacentes a fim de isolar o disjuntor falhado.','Nenhuma das anteriores.','','','D',NULL),(82,17,13,2,'O sistema de prote��o com rel�s diferenciais das linhas STIV baseia-se no princ�pio "+

"da:','Diferen�a do n�vel de tens�o.','Compara��o de corrente.','Fuga a terra.','Linha morta.','Nenhuma das anteriores.','','','B',NULL),(83,1,13,2,'A prote��o diferencial de barra da SE-IVP � composta por:','Um �nico rel� para "+

"prote��o das barras A e B.','Conjunto de rel�s para prote��o das barras A e B de modo compartilhado.','Conjunto de rel�s para prote��o das barras A e B individualmente.','Rel�s digitais com seletividade da barra a proteger.','Nenhuma "+

"das anteriores.','','','C',NULL),(84,17,13,2,'Possuem semelhan�a nas filosofias de prote��o e nos tipo de equipamentos de prote��o as linhas:','CVO e ARE.','LON 1 e LON 2.','SSA 2 e STIV 1.','STIV 3 e ARE.','STIV 1 e STIV "+

"2.','','','E',NULL),(85,17,14,4,'A fun��o principal da prote��o por rel�s �:  ','Desligar uma linha que apresente defeito.','Promover a retirada  r�pida de servi�o do DJ, mais pr�ximo ao defeito. ','Promover uma r�pida retirada de "+

"servi�o de um elemento do sistema, quando ele sofre curto-circuito ou quando come�a a operar de modo anormal que possa causar danos ou interferir com a correta opera��o do sistema.','Promover a retirada de servi�o do elemento "+

"defeituoso, o mais r�pido poss�vel, devido � PV.','Todas alternativas est�o corretas. ','','','C',NULL),(86,17,14,4,'A fun��o secund�ria da prote��o por rel�s �:','Promover a indica��o da localiza��o do tipo de defeito, visando uma "+

"r�pida repara��o e possibilidades de an�lise da efici�ncia e caracter�sticas da prote��o adotada.','Promover a indica��o do defeito do elemento causador do curto-circuito. ','Indicar a localiza��o do defeito e isolar o elemento "+

"defeituoso do sistema.','Auxiliar na an�lise do defeito para a opera��o em futuras ocorr�ncias.','Todas as alternativas est�o incorretas. ','','','A',NULL),(87,1,14,4,'No bay de transfer�ncia da SECMO, existe 4 botoeiras destinadas a "+

"interligar os rel�s de prote��o para defeitos fase-fase e fase-terra ou trif�sicos aos autotransformadores auxiliares, possibilitando aos rel�s op��es na polariza��o de tens�o. S�o elas:','BS 1,BS 2, BS 3, BS 4.','21 TS, 21 TSS, 21 "+

"NTS, 21 NT. ','TS 4, TS 6, TS 9, TS 12.','BS 4, BS 6, BS 9, BS 12.','TB 1, TB 4, TB 6, TB 9. ','','','D',NULL),(88,17,14,4,'Qual � a sigla da chave seletora de potencial de fase, na SECMO?\n\n','TD.','PVS. ','BS 12.','43 T.','VS. "+

"','','','E',NULL),(89,17,10,4,'Qual o procedimento do operador para rearme (86 BA e  86 BB)  e recomposi��o quando houver a atua��o da prote��o Diferencial de Barras 525 Kv  em Londrina  ?\n\n\n','Calar alarmes e anotar as "+

"sinaliza��es','Aguardar 3 min. e ent�o rearmar prote��o  ','Tentar fechar Dj�s da Barra sem o reset','Somente ap�s inspe��o detalhada no local e autoriza��o do COSE','Somente com autoriza��o do chefe de turno ','','','D',NULL),"+

"(90,17,10,1,'Com rela��o a fun��o de religamento autom�tico da LT IVP-LON2 (monopolar)  quando ela operar� religando a linha? \n\n','Quando operar a prote��o 59H/59L','Quando operar a prote��o Falha DJ.','Quando atuarem as prot. "+

"Instant�neas e para faltas com envolvimento de terra.','Quando operar a prot. Sobrecorrente Direcional de Neutro Temporizada � 67NT','Somente para faltas entre fases   ','','','C',NULL),(91,17,1,1,'Qual procedimento para rearme de "+

"bloqueio por � Falha DJ 1042�  em Londrina e posterior recomposi��o pela opera��o?\n\n','Aguardar 3 min.','Somente com autoriza��o do chefe turno  ','Somente ap�s abertura das CS 1041 e 1043 e autoriza��o do COSE','Rearmar a prote��o "+

"imediatamente','Nenhuma alternativa � correta ','','','C',NULL),(92,17,15,4,'Em qual valor de tens�o na LT SOS 1, o rel� de sobretens�o 59, enviar� sinal de abertura p/ o DJ 732?','250 kv','265 kv','270 kv','276 "+

"kv','290kv','','','D',NULL),(93,17,15,4,'Qual � a fun��o da botoeira 85 CS?','Efetuar teste de sinal de teleprote��o ( Carrier)','Ligar e desligar o rel� 79 do  religamento autom�tico.','Enviar sinal de bloqueio de abertura de DJ a "+

"outra extremidade da LT.','Ligar e desligar o sistema Carrier ( teleprote��o) da prote��o primaria. ','N.D.A','','','D',12),(94,17,15,4,'Qual dos rel�s n�o faz parte da prote��o secund�ria?','Rel� 67NP','Rel� 21-1','Rel� 21 N','Rel� "+

"67 N','2T3','','','A',12),(95,17,15,4,'Em caso de defeito fora da �rea protegida pelo rel� 21-P, quais s�o os rel�s que efetuam o seu bloqueio?\n\n','Rel�s 79 e 85','Rel�s 67 N e 21-1','Rel�s 94B e 2T2','Rel�s 21S e 85','Rel�s 68 e "+

"50N','','','D',12),(96,17,1,1,'Relativamente � prote��o das linhas STIV-I  e STIV-II 525 Kv da se Ivp, no que se refere ao m�dulo AAC 51, podemos afirmar que:','Led I aceso indica �Defeito � Terra�, atua��o da bobina M1;','Led II "+

"aceso indica �Partida fase A�, atua��o da bobina M2;','Led III aceso indica �Partida fase C�, atua��o da bobina M3;','Apenas a alternativa �C� est� correta;','','','','D',12),(97,17,1,2,'Relativamente � prote��o das linhas STIV-I  e "+

"STIV-II 525 Kv da se Ivp, no que se refere �s alimenta��es de corrente cont�nua dos PPS�s 10 e 20, � correto afirmar que:','No PPS 20 o dj 19 alimenta o �Rearme da sinaliza��o dos m�dulos AAC51, AAC59, AAC67 e LAC125� proveniente do "+

"PDC-2/dj CB-10','No PPS 10 o dj 9 alimenta o �Conversor LAC133, o rearme de disparo LBC3, 23, 63 e  43� proveniente do PDC-1/dj CB-11','No PPS 20 o dj 11 alimenta o �Rearme o rearme de disparo LCC61, 23, 43, 119, 136 � proveniente do "+

"PDC-2/dj CB-11. ','','','','','A',12),(98,17,1,2,'Relativamente � prote��o das barras A e B 525 Kv da se Ivp, no que se refere �s alimenta��es de corrente cont�nua, assinale a alternativa correta:','Para o PPS 01/Barra A, vem do dj "+

"Q-78  e para o PPS 02/Barra B, vem do dj Q-79, ambos do Quadro de Distribui��o de 125 Vcc.','Para o PPS 01 (Barra A), vem do dj e para o Q-88 para o e para o PPS 02 (Barra B) vem do dj Q- 89, ambos do Quadro de Distribui��o de 125 "+

"Vcc.','Os rel�s de disparo podem ser ativados pela atua��o do rel� diferencial de qualquer fase, pela atua��o de falha de qualquer fase ou pela atua��o de falha de qualquer disjuntor referente � barra em quest�o','As alternativas B e "+

"C est�o corretas','','','','D',12),(99,17,8,2,'Na SE IVP, em religamentos autom�ticos de linhas, o modo de acionamento dos disjuntores pode ser ?','Monof�sico, bif�sico ','Monof�sico, trif�sico ','Bif�sico, trif�sico ','Monof�sico, "+

"bif�sico, trif�sico ','nenhuma das alternativas','','','B',12),(100,17,8,2,'O esquema de teleprote��o DUTT, da SE IVP significa:','Transfer�ncia direta de disparo com subalcance','Desbloqueio por compara��o direcional','Esquema de "+

"fraca alimenta��o','Bloqueio por oscila��o de potencia','Nenhuma das anteriores','','','A',12),(101,17,8,2,'O esquema de teleprote��o PUTT, da SE IVP significa:','Bloqueio por oscila��o de pot�ncia ','Transfer�ncia de disparo com "+

"subalcance permiss�vel ','Desbloqueio por compara��o direcional','Perda de sincronismo','Nenhuma das anteriores','','','B',12),(102,17,8,5,'O esquema de teleprote��o POTT, significa:','Desbloqueio por compara��o direcional','Bloqueio "+

"por oscila��o de pot�ncia ','Transfer�ncia de disparo com sobrealcance permiss�vel ','Esquema de fraca alimenta��o ','Nenhuma das alternativas anteriores','','','C',12),(103,17,9,4,'Com rela��o aos rel�s utilizados na Prote��o "+

"Diferencial de Barra da SE CMO, assinale aquele que n�o pertence a este sistema:','Rel� diferencial 87B','Rel� de Bloqueio 86B','Rel� Auxiliar 87 TX','Rel� direcional 67N','','','','D',12),(104,17,9,4,'Complete, com o rel� correto, o "+

"texto extra�do do Sistema de Prote��o das LTs de 230 kV da SE CMO:\n\n�Aten��o especial deve ser dada a opera��o do rel� ____, pois o mesmo possui duas bandeirolas referentes as suas unidades temporizada e instant�nea.\nA informa��o "+

"dever� ser dada da seguinte forma: \n- Atuou o rel� ____ unidade instant�nea - (bandeirola da esquerda) \n- Atuou o rel� ____ unidade temporizada - (bandeirola da direita)�\n','21P ','67N','51N','87B','','','','B',12),"+

"(105,17,9,4,'Dentre os procedimentos do Operador quando da atua��o da Prote��o Secund�ria, assinale abaixo aquele que n�o condiz com os apontados no Manual:','A)	Reconhecer o alarme no anunciador ou no sistema digital e anotar a "+

"ocorr�ncia e hor�rio da mesma.','B)	Rearmar as bandeirolas dos rel�s e rearmar o alarme visual no anunciador ou no sistema digital.','C)	Proceder conforme instru��o de recomposi��o do m�dulo do manual de opera��o.','Informar o "+

"COT e a Equipe de Prote��o.   ','','','','D',12),(106,1,7,2,' Com referencia aos sistemas de opera��o empregados pela ELETROSUL vimos que o desligamento de terminais de linhas de transmiss�o protegidas por alguns esquemas de prote��o, "+

"depende da opera��o da prote��o em ambos os terminais da linha.  Considerando a Figura  abaixo, cuja linha de transmiss�o � protegida por um esquema CDD ou POTT.  Caso o terminal B esteja aberto por qualquer raz�o (linha operando em "+

"vazio) e ocorra um defeito no ponto F1, embora haja a opera��o da unidade 21PA no terminal A, enviando sinal de desbloqueio para o terminal B, o terminal A n�o ser� desligado uma vez que o mesmo n�o recebeu sinal de desbloqueio "+

"proveniente do terminal B (terminal encontra-se aberto). Buscando-se contornar esta situa��o, as prote��es s�o dotadas de um recurso denominado:\n\n','L�gica de Eco.  Esta l�gica, ap�s decorrido um determinado tempo, manda de volta "+

"para o outro terminal remoto o sinal recebido � da� derivando o nome Eco.  Este sinal ao chegar de volta ao terminal de origem, libera a unidade 21PA para desligamento.','Esta l�gica de controle e prote��o � denominada prote��o de "+

"weak infeed;','Stub, termo em ingl�s que traduzido para o portugu�s seria �TOCO�;','De modo a contornar-se esta situa��o os terminais de linhas de transmiss�o s�o dotados de prote��o contra Linha Morta;','nenhuma das alternativas "+

"acima','','','A',12),(107,1,1,1,'97','1','','','','','','','A',12),(108,1,1,1,'98','1','','','','','','','A',12),(109,1,1,1,'99','2','','','','','','','A',12),(110,1,1,1,'100','1','','','','','','','A',12),"+

"(111,1,1,1,'sfsf','sf','ffff','','','','','','A',0)");
         
         //s.execute("INSERT INTO usuariostb VALUES );
        		
         statements.add(psInsert);
         //psInsert.setInt(1, 1956);
         //psInsert.setString(2, "Webster St.");
         psInsert.executeUpdate();/*
         
         //public void Salvar_novo_registroJtable(Usuariotb usuariotb){

		//}
     /*
         
         
         
         /*System.out.println("Inserted 1956 Webster");*/

		 /*parameter 1 is num (int), parameter 2 is addr (varchar)*/
         /*psInsert = conn.prepareStatement(
                        "insert into usuariostb (usuarios, senha, tipo) values (?, ?, ?)");
         
         statements.add(psInsert);

         //psInsert.setInt(1, 3);
         psInsert.setString(1, "user");
         psInsert.setString(2, "ee11cbb19052e40b07aac0ca060c23ee");
         psInsert.setInt(3, 1);
         psInsert.executeUpdate();*/


         /*
         psInsert.setInt(1, 1910);
         psInsert.setString(2, "Union St.");
         psInsert.executeUpdate();
         System.out.println("Inserted 1910 Union");

         psUpdate = conn.prepareStatement(
                     "update location set num=?, addr=? where num=?");
         statements.add(psUpdate);

         psUpdate.setInt(1, 180);
         psUpdate.setString(2, "Grand Ave.");
         psUpdate.setInt(3, 1956);
         psUpdate.executeUpdate();
         System.out.println("Updated 1956 Webster to 180 Grand");

         psUpdate.setInt(1, 300);
         psUpdate.setString(2, "Lakeshore Ave.");
         psUpdate.setInt(3, 180);
         psUpdate.executeUpdate();
         System.out.println("Updated 180 Grand to 300 Lakeshore");
*/
         rs = s.executeQuery("SELECT * FROM (SELECT ROW_NUMBER() OVER () AS rownumber, num_pergunta, enunciado_PerguntasTB, acertou, id_PerguntasTB FROM perguntastb perguntastb INNER JOIN estatisticastb estatisticastb ON perguntastb.id_PerguntasTB = estatisticastb.num_pergunta ) AS TR WHERE rownumber <= 10 and acertou = 0 ORDER BY num_pergunta DESC");
         
         //int number; 
         //boolean failure = false;
         
         
         while (rs.next())
         {
        	System.out.println("");
            
            System.out.println(rs.getInt(1));
            System.out.println(rs.getInt(2));
            System.out.println(rs.getString(3));
            System.out.println(rs.getInt(4));
            System.out.println(rs.getInt(5));
            System.out.println("");
         }
         
         /*if (!rs.next())
         {
             failure = true;
             reportFailure("No rows in ResultSet");
         }

         if ((number = rs.getInt(1)) != 300)
         {
             failure = true;
             reportFailure(
                     "Wrong row returned, expected num=300, got " + number);
         }

         if (!rs.next())
         {
             failure = true;
             reportFailure("Too few rows");
         }

         if ((number = rs.getInt(1)) != 1910)
         {
             failure = true;
             reportFailure(
                     "Wrong row returned, expected num=1910, got " + number);
         }

         if (rs.next())
         {
             failure = true;
             reportFailure("Too many rows");
         }

         if (!failure) {
             System.out.println("Verified the rows");
         }*/

         // delete the table
         //s.execute("drop table location");
         //System.out.println("Dropped table location");

         /*
            We commit the transaction. Any changes will be persisted to
            the database now.
          */
         conn.commit();
         System.out.println("Committed the transaction");

         if (framework.equals("embedded"))
         {
             try
             {
                 DriverManager.getConnection("jdbc:derby:;shutdown=true");
             }
             catch (SQLException se)
             {
                 if (( (se.getErrorCode() == 50000)
                         && ("XJ015".equals(se.getSQLState()) ))) {
                     System.out.println("Derby shut down normally");
                 } else {
                     System.err.println("Derby did not shut down normally");
                     printSQLException(se);
                 }
             }
         }
     }
     catch (SQLException sqle)
     {
         printSQLException(sqle);
     } finally {
         // release all open resources to avoid unnecessary memory usage

         // ResultSet
         try {
             if (rs != null) {
                 rs.close();
                 rs = null;
             }
         } catch (SQLException sqle) {
             printSQLException(sqle);
         }

         // Statements and PreparedStatements
         int i = 0;
         while (!statements.isEmpty()) {
             // PreparedStatement extend Statement
             Statement st = (Statement)statements.remove(i);
             try {
                 if (st != null) {
                     st.close();
                     st = null;
                 }
             } catch (SQLException sqle) {
                 printSQLException(sqle);
             }
         }

         //Connection
         try {
             if (conn != null) {
                 conn.close();
                 conn = null;
             }
         } catch (SQLException sqle) {
             printSQLException(sqle);
         }
     }
 }
 private void loadDriver() {
     try {
         Class.forName(driver).newInstance();
         System.out.println("Loaded the appropriate driver");
     } catch (ClassNotFoundException cnfe) {
         System.err.println("\nUnable to load the JDBC driver " + driver);
         System.err.println("Please check your CLASSPATH.");
         cnfe.printStackTrace(System.err);
     } catch (InstantiationException ie) {
         System.err.println(
                     "\nUnable to instantiate the JDBC driver " + driver);
         ie.printStackTrace(System.err);
     } catch (IllegalAccessException iae) {
         System.err.println(
                     "\nNot allowed to access the JDBC driver " + driver);
         iae.printStackTrace(System.err);
     }
 }
 private void reportFailure(String message) {
     System.err.println("\nData verification failed:");
     System.err.println('\t' + message);
 }
 public static void printSQLException(SQLException e)
 {
     while (e != null)
     {
         System.err.println("\n----- SQLException -----");
         System.err.println("  SQL State:  " + e.getSQLState());
         System.err.println("  Error Code: " + e.getErrorCode());
         System.err.println("  Message:    " + e.getMessage());
         e = e.getNextException();
     }
/* private void parseArguments(String[] args)
 {
     if (args.length > 0) {
         if (args[0].equalsIgnoreCase("derbyclient"))
         {
             framework = "derbyclient";
             driver = "org.apache.derby.jdbc.ClientDriver";
             protocol = "jdbc:derby://localhost:1527/";
         }
     }
 }
}*/
 }
}  
