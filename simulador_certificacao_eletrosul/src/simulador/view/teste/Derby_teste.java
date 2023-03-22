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
"(1,1,1,1,'Na caixa “PONTO DIGITAL” a indicação “Falha de Aquisição” corresponde a:','Ponto fora de varredura;','Alarme não reconhecido no visor de alarmes;','A ligação para adquirir o dado está inoperante;','Indicação de validade do "+

"ponto na UTR de origem.','','','','C',NULL),(2,1,1,1,'Deve ser observado antes do envio de um comando:','Confirmar a habilitação de controle da UTR está para “SAGE”:','Confirmar desativados “Num Lock” e ”Caps Lock”;','Ambas as "+

"alternativas estão corretas;','','','','','C',NULL),(3,1,1,1,'Deve ser dada atenção permanente:','Terminal “não-primário” com apenas os processos HIST, ALR e SERV iniciados;','Terminal “primário” com apenas os processos HIST, ALR e "+

"SERV não iniciados;','Terminal “primário” com apenas os processos HIST, ALR e SERV iniciados','Terminal “não-primário” com apenas os processos HIST, ALR e SERV não iniciados ','','','','D',NULL),(4,1,1,1,'São condições que confirmam o "+

"SAGE operando 100 % normal ','Todos os relógios iguais e atualizados corretamente;','Máquina (s) não-primária (s) com apenas os processos HIST e SERV não iniciados; ','Apenas um modem em comunicação com a UTR;','Confirmar idênticas "+

"nas várias máquinas os valores de medidas, status de equipamentos, relação de pontos em alarme e lista de eventos.','As alternativas A, C e D estão corretas','','','E',NULL),(5,1,1,1,'Na ocorrência de alarme permanente de falha em "+

"processador PP ou PS da UTR MAP, é correto afirmar:','Tem caráter de urgência e a causa provável é uma falha transitória num processador da UTR MAP;','Deverá ser resetada esta máquina e comunicado o COSE;','Tem caráter de advertência "+

"e o Operador deverá aguardar a normalização por até 1 minuto, caso não normalize, passar a operar em modo convencional.','O Operador deve resetar a máquina e, na persistência da situação, acionar a manutenção. ','Todas as alternativas "+

"estão corretas;','Somente as alternativas A, B e D estão corretas;','','F',NULL),(7,2,2,5,'O que é  controle de tensão?','Conjunto de ações para manutenção dos níveis de tensão dentro de parâmetros que atendam aos requisitos de "+

"qualidade e confiabilidade operativa do sistema.','Monitoração de grandezas ou do estado de equipamentos e linhas de transmissão visando a  adoção de medidas para obtenção de valores ou estados desejados.','Estado do sistema "+

"caracterizado pela sua topologia e parâmetros elétricos em tempo real.','Ação de desenergização manual ou automática de um equipamento.','Execução de comando efetuado a distância através do sistema digital, do relé de proteção ou do "+

"painel convencional.','','','A',NULL),(8,4,4,2,'Quais são as atribuições do COSE?','Supervisionar, coordenar e controlar as instalações não integrantes da Rede de Operação, em conjunto com as demais empresas envolvidas;','Coordenar e "+

"controlar as instalações não integrantes da Rede Básica, em conjunto com as demais empresas envolvidas;','Orientar, as instalações  integrantes da Rede de Operação, em conjunto com as demais empresas envolvidas;','Observar,  e "+

"controlar as instalações não integrantes da Rede Básica, em conjunto com as demais empresas envolvidas;','Interagir, e controlar as instalações  integrantes da Rede de Operação.','','','A',NULL),(10,6,6,5,'De acordo com a Norma de "+

"Operação de Redes – Comunicação Verbal, a comunicação verbal na operação em tempo real deve ser precisa, formal, padronizada, clara e objetiva. Ela determina também que uma seqüência padronizada deve ser observada a fim de garantir o "+

"perfeito entendimento das informações.\r\n\r\nEnumere as alternativas abaixo de acordo com a seqüência padrão e em seguida escolha a resposta correta dentre as opções: \r\n\r\n(  ) Encerramento\r\n(  ) Transmissão de mensagem pelo "+

"emissor;\r\n(  ) Confirmação, pelo transmissor, do entendimento da mensagem;\r\n(  ) Identificação dos interlocutores: local (Subestação, COSE ou Agente) e nome do receptor/transmissor;\r\n(  ) Repetição da mensagem recebida pelo "+

"receptor;\r\n','4, 3, 2, 5, 1;','1, 2, 5, 4, 3;','5, 2, 4, 1, 3;','3, 4, 5, 2, 1;','2, 5, 4, 3, 1.','','','C',NULL),(11,7,7,5,'Com relação a periodicidade das inspeções nas instalações sob responsabilidade da ELETROSUL, é correto "+

"afirmar:','Em Controladoras - diariamente, com 1 (uma) inspeção diária, podendo esta ser dividida em 3 partes (uma por turno);  ','Em Controladas com operação local - diariamente, com 1 (uma) inspeção diária, em dias úteis;','Em "+

"Controladas sem operação local - quinzenalmente, exceto nas Subestações Florianópolis, Desterro, Joinville e Caxias 5, onde a inspeção deverá ocorrer semanalmente;  ','As alternativas a, b, c e d, estão corretas;','Nenhumas das "+

"alternativas estão corretas.','','','D',NULL),(12,8,8,5,'Uma das situações em que pode ser emitido um único RRO, é?','Ocorrências simultâneas em instalações diversas.','Ocorrências simultâneas em uma mesma instalação.','Ocorrências em "+

"um mesmo turno.','Ocorrências em um mesmo dia.','Nenhuma das anteriores.','','','B',NULL),(13,9,9,1,'Com relação às normas de Segurança em Instalações, verifique as afirmações abaixo quanto a verdadeiro ou falso e depois assinale a "+

"alternativa correta:\r\n\r\n(   ) -Próximo a instalações com tensão, o transporte de escadas ou objetos alongados pode ser feito portando-os na posição horizontal ou vertical.\r\n(   ) -Não é permitido o uso de equipamentos de limpeza "+

"que utilizem água sob pressão dentro da zona controlada em áreas energizadas.\r\n(   ) -É proibido o uso de guarda-chuvas, escadas e trenas metálicas ou de pano com alma de aço, em áreas energizadas, porém o uso de adereços metálicos, "+

"como relógios, pulseiras, etc. é permitido.\r\n(   ) -A distância mínima necessária para execução de serviço em subestações na classe de tensão de 230 kV é 3,00 metros.\r\n(   ) -A distância mínima necessária para execução de serviço "+

"em subestações na classe de tensão de 500 kV é 3,40 metros.\r\n','V, V, V, V, V','F, F, F, F, F','V, V, F, F, F','F, V, F, F, V','','','','D',NULL),(14,10,10,5,'Na execução de um PL qual a sequência correta dos procedimentos em "+

"relação aos atestados. ','Confirmação prévia,  inspeção da área,  atestado isolamento, recebimento da área, devolução da área.  ','Atestado isolamento, inspeção da área, recebimento da área, confirmação prévia, devolução da área.     "+

"Atestado isolamento, inspeção da área, recebimento da área, confirmação prévia, devolução da área.     Atestado isolamento, inspeção da área, recebimento da área, confirmação prévia, devolução da área.     ','Confirmação prévia, "+

"isolamento da área, recebimento da área, devolução da área, inspeção da área.','Inspeção da área, recebimento da área, confirmação prévia, isolamento da área, devolução da área. ','Atestado isolamento, inspeção da área, confirmação "+

"prévia, devolução da área, recebimento da área.','','','C',NULL),(15,11,11,5,'Os serviços executados por empreiteiras ou por empregados da empresa na Subestação, terão como responsável pela segurança:','Responsável do DMS','O Chefe de "+

"Setor e o Chefe de Turno obrigatoriamente','O Dono da empreiteira ','A Divisão da Obra executora dos serviços','','','','D',NULL),(16,12,12,4,'Qual deve ser a  posição da chave 43 T para que o DJ 782 (ATF 1 – CMO) fique com o seu "+

"comando de fechamento remoto bloqueado ?\r\n\r\n','Posição normal','Posição intermediaria','Posição transferida','Posição normal e transferida.','Posição intermediaria e transferida.','','','C',NULL),(18,12,12,4,'Se o DJ 782 (ATF 1) "+

"estiver com a chave 43 T na posição INTERMEDIÁRIA, em qual ou quais disjuntores atuará a proteção?\r\n\r\n','Somente no DJ 782','Somente no DJ 772','Fica momentaneamente sem proteção','Nos DJ’s 772 e 782','Nos DJ 782 e "+

"792','','','D',NULL),(19,12,12,4,'Quais os tipos de comandos que possuem as chaves seccionadoras da SE CMO?\r\n\r\n','Comando elétrico remoto convencional e digital','Apenas comando mecânico','Comando mecânico e elétrico "+

"local','Comando elétrico local e remoto digital','As alternativas A e C estão corretas','','','E',NULL),(20,12,2,1,'Quais são as condições de intertravamento que devem estar satisfeitas para efetuar comando na CS 1067T da LT IVP1 na "+

"SE LON?','LT IVP 1 sem tensão e CS 1067 aberta.','LT IVP 1 sem tensão e CS 1061 aberta','LT IVP 1 sem tensão e CS 1063 aberta.','CS’s 1061 e 1067 abertas.','Barra B 525 KV da SE LON.desenergizada. e aterrada.','','','A',NULL),"+

"(25,12,2,1,'Qual a finalidade do dispositivo CK instalado na CS 1047T da LT IVP2  na SE LON?','Na abertura da CS a lâmina principal abre primeiro e, antes da haste auxiliar abrir, o circuito é aberto na câmara de SF6.','O arco da "+

"corrente induzida na linha é extinto no momento do aterramento numa câmara com SF6.','Suprimir a indução de corrente que é considerável onde existem linhas paralelas para não danificar a CS de aterramento.','No fechamento da CS a "+

"haste auxiliar faz o primeiro contato, fechando o arco na camara de SF6.','Todas as alternativas estão corretas.','','','E',NULL),(27,12,2,1,'Quais alarmes devem sinalizar no visor de alarmes do SAGE quando o relé K69 que faz a "+

"supervisão da alimentação 480VCA das motobombas do DJ 1042 (AREVA) da LT IVP2 na SE LON,  ficar inoperante (queimado)?\r\n\r\n','DJ 1042 bloqueado abertura e fechamento.','DJ 1042  falta alimentação CA e CC.','DJ 1042 bloqueado "+

"fechamento e defeito circuito hidráulico.','DJ 1042 baixo nível óleo e baixa pressão SF6.','DJ 1042 excesso operação motobomba e relé térmico operado.','','','C',NULL),(28,12,13,2,'O comando convencional dos disjuntores a partir da "+

"mesa de comando funciona em:','Série com o sistema digital via SAGE;','Paralelo com o sistema digital via SAGE;','Série e paralelo com o sistema digital via SAGE;','Oposição ao sistema digital via SAGE;','Nenhuma das respostas "+

"anteriores.','','','B',NULL),(29,12,13,2,'O sincronismo dos disjuntores da subestação Ivaiporã poderá ser feito digitalmente, através do sistema digital de telecontrole na subestação Ivaiporã ou na subestação controladora, usando para "+

"isso:\r\n\r\n','lógica implementada nas UAC´s AM 1703 para os disjuntores DJ 1002 e DJ 1042;','A lógica implementada nos relés de proteção SEL 451 para os disjuntores DJ 1070 e DJ 1072;','relé de sincronismo 7VK512 Siemens para os "+

"demais disjuntores;','O sincronoscópio anexo ao painel de controle do Bay 1;','As alternativas A, B e C estão corretas.  ','','','E',NULL),(30,12,13,2,'Com relação ao comando elétrico convencional das Chaves Seccionadoras:','Todas as "+

"Chaves Seccionadoras da SE-IVP podem ser operadas;','Somente as Chaves Seccionadoras Gould-ITE podem ser operadas;','Somente as Chaves Seccionadoras Lorenzetti podem ser operadas;','Somente as Chaves Seccionadoras da LT-LON 2 não "+

"possuem esse tipo de comando;','Nenhuma Chave Seccionadora da SE-IVP possui esse tipo de comando.','','','D',NULL),(31,12,3,4,'Com relação a chave 43T do DJ 782 do TF1 na SE Campo Mourão podemos afirmar que:\r\n\r\n','Com a chave 43T "+

"seletada para NORMAL, a proteção atuará nas barras P e T.','Com a chave 43T seletada para TRANSFERIDO, a proteção atuará provocando o     desligamento das LTSOS1 e LTSOS2 para evitar sobrecarga no TF1. ','Com a chave 43T seletada para "+

"INTERMEDIÁRIO, a proteção atuará nas LIAPA e  LIMGA para que não haja uma sobretensão na subestação da COPEL.','Com a chave 43T seletada para TRANSFERIDO, caso haja algum defeito no TF1 teremos uma desligamento Geral da SE Campo "+

"Mourão.','Com a chave 43T seletada para INTERMEDIÁRIO, a proteção que atua sobre o DJ 782 também é enviada ao DJ 772 (TRANSFERÊNCIA).  ','','','E',NULL),(32,12,14,4,'Sobre os disjuntores da SECMO. ','Os Dj’s Magrini foram modificados "+

"para que os relés XE e XE’ dêem trip por baixa pressão de gás e ar e bloqueiem o fechamento.','Os Dj’s Magrini apenas bloqueiam o fechamento por baixa pressão de gás.','Os Dj’s Magrini apenas bloqueiam o fechamento por baixa pressão "+

"de ar.','Todas as alternativas estão corretas.','Todas as alternativas estão incorretas.','','','A',NULL),(33,12,14,4,'Quanto ao comando do Disjuntor.','disjuntor não possui comandos manuais.','O disjuntor possui comando elétrico "+

"local de abertura e fechamento; comando elétrico remoto via painel de controle para abertura e fechamento; comando elétrico remoto via sistema digital para abertura e fechamento.','O comando manual do disjuntor está fora de operação. "+

"','Todas alternativas estão corretas.','Todas alternativas estão incorretas.','','','B',NULL),(34,12,14,4,'Quais os tipos de comando das seccionadoras?','Comando mecânico.','Comando elétrico local. ','Comando elétrico remoto, via "+

"painel de controle e/ou digital, para abertura e fechamento.','Todas alternativas estão corretas.','Todas alternativas estão incorretas.','','','D',NULL),(35,12,14,4,'Sobre as alimentações  auxiliares das seccionadoras.','As "+

"alimentações essenciais e complementares, são fornecidas pelo sistema de CA.','As alimentações essenciais compreendem  cc para os circuitos de comando e intertravamento e Ca para os motores. ','As alimentações complementares "+

"compreendem aquelas destinadas aos circuitos de comando da CS.','Todas alternativas estão corretas.','Todas alternativas estão incorretas. ','','','B',NULL),(36,12,15,4,'Quais os tipos de comando podem ser efetuados nos disjuntores "+

"230 Kv da SECMO','Apenas comando local e via SAGE.','Apenas comando via SAGE','Apenas comando local e remoto via painel de controle.',' Comando local, remoto via painel e remoto via SAGE. ','N.D.A','','','D',NULL),(37,12,15,4,'Quais "+

"os procedimentos para efetuar um comando mecânico na CS Brush Power 230 kv da SECMO.','Seletar a chave local / remoto para posição desligada, inserir a manivela e girar no  sentido desejado.','Inserir a manivela e girar no sentido "+

"desejado.','Não possui comando mecânico.','Seleta a chave para posição desejada e dá comando de partida no motor.','N.D.A','','','A',NULL),(38,12,15,4,'Qual é o relé que faz a supervisão do sincronismo para o fechamento do DJ, via "+

"SAGE. ','Relé 85','Relé 27','Relé 25','Relé 51','Relé21','','','C',NULL),(39,12,15,4,'Qual é a função da chave 43T, no Bay do ATF 01','Desligar o comando remoto do DJ 782','Transferir a proteção do DJ 782 para o DJ 772 do módulo de "+

"transferência.','Efetuar a seleção local / remoto do DJ 782.','Na posição transferida, mantém a proteção nos DJ’s 772 e 782. ','N.D.A','','','B',NULL),(40,12,15,4,'Qual é a finalidade da lâmpada amarela referente as chaves "+

"seccionadoras, localizadas no painel de controle da SECMO.','Sinaliza CS em transito.','Sinaliza falta CC na CS.','Sinaliza CS fechado.','Sinaliza falta de CA na CS.','Sinaliza intertravamento satisfeito.','','','E',NULL),"+

"(41,12,15,4,'Caso não consiga fechar um DJ, via SAGE, devido a falha no relé de sincronismo, qual o procedimento deverá ser efetuado para  fechar o DJ?\n\n','Resetar o relé 25 no SAGE.','Aguardar 3 minutos e efetuar nova "+

"tentativa.','Desativar o relé 25 manualmente, diretamente no painel de controle, pois não existe a possibilidade pelo telecontrole.','O sincronismo via SAGE independe do relé 25.','N.D.A','','','C',NULL),(42,12,15,4,'As CS’s finais 1 "+

"(barra) e finais 3 ( linhas) são intertravadas com quais equipamentos.','As CS finais 1, intertrava-se com o respectivo DJ e a CS de By pass.','As CS’s final 3, intertrava-se com o respectivo DJ e a CS de By pass.','As CS’s final 1 e "+

"3, não possui intertravamento, podendo ser manobradas a qualquer momento.','AS CS’s final 1 e 3, são intertravadas apenas com seu respectivo DJ.','N.D.A','','','D',NULL),(43,12,7,4,'As chaves secionadoras possuem os seguintes tipos de "+

"comando:','Comando Mecânico;','Comando Elétrico Local;','Comando Elétrico  Remoto, via painel de controle, para abertura e fechamento;','Comando Elétrico Remoto via sistema digital, para abertura e fechamento;','Todas as alternativas "+

"acima estão corretas  ','','','E',NULL),(44,1,7,4,'Em conformidade com o circuito de intertravamento dos DJs, a operação dos relés XE e XE’ implicam no(a):','Impedimento de acionamento das CSs isoladoras do DJ Magrini em "+

"Questão;','Bloqueio da abertura do DJ relacionado;','Atuação do esquema de Falha Disjuntor da SE CMO;','Trip por baixa pressão de gás e ar  e bloqueia o fechamento do DJ envolvido;','Nenhuma das alternativas acima.','','','D',NULL),"+

"(45,12,7,4,'Os DJ’s 1050 e 1052 na SE IVP, são do fabricante VATECH, tipo FA4R-40,  e de acordo com o Manual de Instalação, com relação ao seu mecanismo de operação hidráulico  Pressões SF6, é correto afirmar:','Nominal: 7,0 Bar,  -  "+

"1° estágio: 7,2 Bar – Alarme - 2° estágio: 8,0 Bar – TRIP/Bloqueio fechamento;','Nominal: 7,2 Bar,  -  1° estágio: 8,2 Bar – Alarme - 2° estágio: 7,0 Bar – TRIP/Bloqueio fechamento;','Nominal: 8,0 Bar,  -  1° estágio: 7,2 Bar – Alarme "+

"- 2° estágio: 7,0 Bar – TRIP/Bloqueio fechamento.','Nominal: 5,0 Bar,  -  1° estágio: 7,2 Bar – Alarme - 2° estágio: 9,0 Bar – TRIP/Bloqueio fechamento;','Nenhuma das alternativas acima.','','','C',NULL),(47,12,7,4,'Os DJ’s 1050 e "+

"1052 na SE IVP, são do fabricante VATECH, tipo FA4R-40,  e de acordo com o Manual de Instalação, com relação ao seu mecanismo de operação hidráulico  Pressões do óleo, é correto afirmar:\n\n','Nominal: 326 Bar - 1° estágio: 264 Bar – "+

"Alarme/Bloqueio fechamento - 2° estágio: 250 Bar – Trip/Bloqueio fechamento;','Nominal: 250 Bar - 1° estágio: 326 Bar – Alarme/Bloqueio fechamento - 2° estágio: 264 Bar – Trip/Bloqueio fechamento;','Nominal: 264 Bar - 1° estágio: 250 "+

"Bar – Alarme/Bloqueio fechamento - 2° estágio: 264 Bar – Trip/Bloqueio fechamento;','Nominal: 326 Bar - 1° estágio: 264 Bar – Alarme/Bloqueio fechamento - 2° estágio: 250 Bar – Trip/Bloqueio fechamento;','Todas as alternativas acima "+

"estão corretas ','','','A',NULL),(48,13,8,1,'O transformador TF-3 da SE LON, possui um sistema de comutação sob carga com derivações (tap,s). Quantas são as derivaçõese e como são numeradas?','19 derivações, numeradas de 9R a 9L, "+

"passando pelo tap central, denominado N','19 derivações, numeradas de 9R a 9L, e não possui tap central','18 derivações, numeradas de 9R a 9L','18 derivações, numeradas de 9R a 9L, passando pelo tap central','Não possui "+

"derivações','','','A',NULL),(49,13,11,1,'O transformador TF-4 da SE LON, possui um sistema de comutação sob carga com derivações (tap’s). Quantas são as derivações e como são numeradas?','19 derivações, numeradas de 1 a 19, e não "+

"possui tap central','19 derivações, numeradas de 1 a 19, passando pelo tap central, denominado 10','18 derivações, numeradas de 1 a 18','18 derivações, numeradas de 1 a 18, passando pelo tap central','Não possui derivações  "+

"','','','B',NULL),(50,14,11,4,'A alimentação principal dos Serviços Auxiliares da SE CMO é feita através','Do terceário do trafo da Copel em 13,8kV','Da linha de distribuição em 34,5kV','De ambos os trafos em paralelo','De qualquer "+

"fonte por conveniência do operador','','','','A',NULL),(51,14,11,4,'As barras de 460 Vca dos serviços auxiliares da SE CMO dispõem de duas fontes de alimentação independentes; qual a filosofia operacional das barras, em condições "+

"normais?','As barras operam separadas, sendo a barra 1 alimentada pela fonte principal e a barra 2 alimentada pela fonte alternativa;','As barras operam interligadas ambas alimentadas pela fonte principal;','As barras operam "+

"interligadas alimentadas simultaneamente por ambas as fontes visando aumentar a confiabilidade;','A filosofia operacional das barras 460Vca são definidas pelo chefe de turno podendo ser alterada a critério do "+

"mesmo.','','','','B',NULL),(52,14,13,2,'Quais os níveis de tensão CA dos serviços auxiliares da SE-IVP?','34,5kV/13,8kV/480V/220V/127V','125V/48V','380V/110V','525kV','Nenhum dos anteriores.','','','A',NULL),(53,3,3,5,'Em instalações "+

"compartilhadas onde a operação do disjuntor de transferência é realizada pela Eletrosul, o COSE será coordenado pelo ONS nas manobras de transferência, recomposição, necessidades de abertura do disjuntor e retorno à operação normal "+

"dos módulos de terceiros que necessitarem utilizar o disjuntor de transferência. Assinale a alternativa correta.','O operador da controladora deverá fazer a coordenação junto aos demais agentes envolvidos;','Os agentes de outras "+

"empresas farão contato com o operador da controladora solicitando o fechamento do DJ de transferência;','O operador verificando a demora da comunicação do COSE, deve iniciar imediatamente as manobras para agilizar os trabalhos;','Os "+

"agentes do ONS farão contato imediatamente com a operador local solicitanto rapidez, segurança e eficiência nas manobras;  ','O COSE coordenará a operação da controladora e informará ao operador da SE para o fechamento do DJ de "+

"transferência.  ','','','E',NULL),(55,12,15,4,'A alimentação em 220 vca, para os DJ’s 230 kv, possui a seguinte finalidade.\n\n','Alimentar os compressores dos DJ’s.','Alimentar a bomba de óleo.','Alimentar a resistência de "+

"aquecimento.','Alimentar circuito de abertura e fechamento.','N.D.A','','','C',NULL),(56,5,5,5,'De que forma é o Relacionamento do COSE com as SE’s Controladas?\nAssinale a alternativa correta:\n\n','De forma direta sempre que "+

"necessitar.','De forma indireta, através da Controladora mesmo estando a SE Controlada em local.','De forma direta, quando a Controlada estiver em Local.','','','','','C',NULL),(57,14,13,2,'Quais são as barras essenciais de 480V da "+

"SE-IVP?','Barras I, II, III, IV e V;','Barras I, II e III;','Barras III, IV e V;','Barras I e II;','A SE-IVP não possui barras essenciais.','','','D',NULL),(58,14,13,2,'No setor de 125 Vcc as lâmpadas de defeito (Terra Positivo ou "+

"Terra Negativo) operam com metade da luminosidade, quando houver um defeito:','Ambas se apagarão;','Uma apagar-se-á e a outra aumentará sua luminosidade;','Ambas aumentarão a luminosidade;','Uma permanece com metade da luminosidade e "+

"a outra fica piscando;','Ambas ficam piscando.','','','B',NULL),(59,14,13,2,'A iluminação de emergência da SE-IVP não contempla:','A sala de controle;','A casa do diesel;','A casa de bombas;','Os corredores da casa de controle;','O "+

"pátio de 525kV da SE.','','','E',NULL),(60,14,4,2,'Quantos   setores de  125Vcc e 48Vcc que existem na subestação de Ivaiporã?','Um setor  de de 125cc apenas.','Há dois setores, um 125 Vcc e um de 48 Vcc.','Um setor  de de "+

"48cc.','Dois setores de de 125cc.','Dois de setores de 48Vcc.','','','B',NULL),(61,14,4,2,'Como operam as Barras dos  Setores  de 48Vcc e 125Vcc na subestação de  Ivaiporã?','Barras em série','Barras Interligadas','Barras  "+

"Separadas','Barras em Paralelo','Barras soldadas','','','C',NULL),(62,14,14,4,'Qual a finalidade do Setor de CC, da SECMO?','Alimentar os equipamentos de comunicação.','Alimentar os dispositivos de proteção. ','O CC é utiilizado "+

"somente na falta de CA.','Alimentar os dispositivos de proteção, alarmes, comunicação, sinalização e sistema DETRE. Na eventual falta de CA, a iluminação de emergência da casa de controle e casa do gerador.','Todas alternativas estão "+

"corretas. ','','','D',NULL),(63,14,14,4,'Em relação aos setores de CC, da SECMO.','Há dois setores, um de 12 Vcc e outro de 125Vcc.','Há três setores: 12Vcc, 48Vcc e 125Vcc. ','Há dois setores, um de 125 Vcc e outro de 48 Vcc.','O "+

"setor de CC é composto apenas pelo 125 Vcc.','Todas as alternativas estão incorretas. ','','','C',NULL),(64,14,14,4,'Para os setores de CC, da SECMO.','Ambos os setores de 48 Vcc e 125 Vcc operam idênticos com relação ao revezamento "+

"nas barras de carga e de operação. Quando um conjunto ( carregador/bateria), estiver alimentando a barra de operação o outro conjunto estará alimentando a barra de carga.','O barramento de carga em nenhum instante deverá ficar "+

"desenergizado, por menor que seja o intervalo de tempo. ','O barramento de 12 Vcc não poderá ficar desenergizado. ','Os setores de 12 Vcc, 48 Vcc e 125 Vcc, operam idênticos com relação ao revezamento nas barras de carga e "+

"operação.','Todas alternativas estão corretas. ','','','A',NULL),(65,14,14,4,'No setor de 125 Vcc da SECMO, como é feito o intertravamento entre os dj’s de alimentação da barra de operação e de carga?','E feito eletricamente.','Não "+

"existe intertravamento. ','Só é feito mecanicamente.','Através do sistema eletromecânico.','Todas alternativas estão corretas. ','','','C',NULL),(66,14,10,1,'No setor de 480 Vca , quando usarmos a fonte alternativa GGDE ( DJ 52E ), "+

"quais DJ’s deverão estar abertos para satisfazer o intertravamento mecânico (chaves) e  isolar diretamente a Barra essencial (Barra II ) ?','52 A1  e  52 C1 ','52 A1  e  52 E','52 C1 e  52 E','52 B  e  52 D','52 E , 52 A1 e 52 "+

"C1','','','D',NULL),(67,14,10,1,'Qual o nível de tensão na entrada dos Carregadores de 125Vcc na SE LON?','13.8 Kv','127 Vca','480 Vca','34,5 Kv','220 Vca','','','C',NULL),(68,14,6,4,'Em relação aos Serviços Auxiliares da SE CMO e "+

"segundo o Manual de Instalação específico desta, qual a finalidade do Grupo Gerador Diesel de Emergência (G.G.D.E.)?\n\n','O grupo gerador de emergência tem por finalidade ser a fonte principal dos Serviços Auxiliares da SE CMO em "+

"460Vca mesmo quando as alimentações de 13,8Kv (TF3)  e 34,5Kv (Copel) estiverem disponíveis;','O G.G.D.E. tem por finalidade suprir os serviços auxiliares da barra II, tensão 460 Vca, na falta de alimentação principal e alternativa, "+

"juntas.','O G.G.D.E. tem por finalidade alimentar exclusivamente o sistema de ar condicionado da SE CMO;','O G.G.D.E. tem por finalidade única a de alimentar o sistema de informática da SE CMO.','','','','B',NULL),(69,14,6,4,'Em "+

"relação aos Serviços Auxiliares da SE CMO e segundo o Manual de Instalação específico desta, qual a finalidade do setor de 460vca?','O setor de 460 Vca tem por finalidade única e exclusiva a de alimentar a iluminação do pátio da SE "+

"CMO;','O setor de 460 Vca tem por finalidade única e exclusiva a de alimentar a central de ar comprimido da SE CMO;','O setor de 460 Vca tem por finalidade única e exclusiva a de alimentar os sistemas de informática e de ar "+

"condicionado da SE CMO;','O setor de 460 Vca tem por finalidade alimentar os dispositivos e equipamentos de controle, iluminação, compressores de ar, desumidificadores, condicionadores de ar, bem como parte dos setores de corrente "+

"contínua, através dos retificadores. ','','','','D',NULL),(70,15,13,2,'O relé TREETECH TM1 instalado no armário individual de cada fase do reator RE 1 é o equipamento utilizado para medição de:\n\n','Temperatura do enrolamento e do "+

"óleo.','Temperatura somente do óleo.','Temperatura somente do enrolamento.','Corrente de entrada do reator.','Corrente de neutro do reator.','','','A',NULL),(71,15,13,2,'O sistema de proteção contra incêndio dos reatores RE 1 "+

"utiliza:','Gás carbônico.','Espuma.','Água nebulizada.','Ar comprimido.','Pó químico.','','','C',NULL),(72,15,13,2,'O sistema de resfriamento do banco de reatores é do tipo:','Óleo natural.','Água natural.','Óleo forçado.','Água "+

"forçada.','Óleo Natural e ar natural (ONAN).','','','E',NULL),(73,15,13,2,'A potência de cada unidade monofásica do reator RE 1 é de:','33,33 VAr','33,33 kVAr','33,33 MVAr','33,33 GVAr','33,33 MW','','','C',NULL),(74,15,1,1,'Qual a "+

"finalidade dos reatores limitadores de corrente (SR-01 e SR-02) aplicados junto aos ATF’s III e IV da subestação Londrina ?','Permitir usar na proteção dos terciários dos ATF’s III e IV dj’s com níveis menores de interrupção de "+

"corrente;','Propiciar que, em caso de “falha-à-terra” no terciário de um dos ATF’s, relé 64-T atue desenergizando o ATF envolvido;  ','Propiciar que, em caso de “falha-à-terra” no terciário de um dos ATF’s, relé 64-T atue alarmando na "+

"sala de comando;','Fornecer referência de corrente para o relé 87-T.   ','','','','A',NULL),(75,15,9,2,'Com relação à operação de Reatores na SE IVP, verifique as afirmações abaixo quanto a verdadeiro ou falso e depois assinale a "+

"alternativa correta:\n\n(   ) O banco é composto por 3 unidades monofásicas, de 525 kV. Uma unidade reserva que pode substituir qualquer uma das fases em caso de problema.\n(   ) O sistema pode ser submetido a uma tensão de até 600 kV "+

"em operação contínua.\n(   ) O supervisório SAGE não dispõe de medição instantânea de grandezas, como corrente e tensão, para o banco de reatores.\n(   ) O equipamento utilizado para a medição de temperatura do enrolamento e do óleo "+

"de cada fase do RE1 é o TREETECH TM1, instalado no armário individual de cada fase do reator.\n','V, V, F, V','V, F, F, F','V, F, F, F','F, F, F, F','','','','A',NULL),(76,15,5,2,'Qual composição do Banco de Reator de IVP?','É "+

"composto por três unidades monofásicas, com uma unidade reserva.','É composto por uma Unidade Trifásica.','C-	É composto por três unidades monofásicas, sem unidade reserva.','A SE IVP não possui banco de "+

"Reatores.','','','','A',NULL),(77,15,5,2,'Quanto ao resfriamento do banco de reator, feita pelos Radiadores instalados nas laterais dos mesmos, pode afirmar que:\n\n','É feita apenas por ventilação forçada.','É feita por ventilação "+

"forçada e circulação de óleo forçada.','A circulação do óleo é tipo convecção natural.','','','','','C',NULL),(78,1,13,2,'Qual o esquema especial de proteção e controle que não está contemplado pela SE-IVP?','Abertura automática das "+

"chaves seccionadoras isoladoras dos disjuntores;','Abertura automática das chaves seccionadoras isoladoras dos disjuntores;','Corte geração por perda de transformador 765/525kV; Interligação Furnas – Retardo abertura DJ´s 525kV;','LT "+

"Ivaiporã – Londrina 1 – Transferência de disparo;','Não existem esquemas especiais nas SE-IVP.','','','A',NULL),(79,16,6,2,'De acordo com o Manual de Instalações - Esquemas Especiais da SE IVP, marque a segunda coluna de acordo com a "+

"primeira e escolha a alternativa que contém a seqüência correta.\n\nColuna 1\n1.Interligação com Furnas – Retardo na abertura dos DJ’s de 525Kv;\n2.Corte de Geração por perda do Transformador 765/525 Kv;\n3.LT’s Ivaiporã – Londrina "+

"Circuitos 1 e 2 – Transferência de Disparo.\n\nColuna 2\n(  ) Esquema que envia sinal de disparo para os disjuntores da LT IVP-SSA1 e canal C ao terminal remoto desta quando ocorre sobrecarga de 50% nos Transformadores 1 ou 2 de "+

"765/525 kV- FURNAS.\n(   ) Retardar em 45 ms a abertura dos disjuntores do lado de 525 kV dos Transformadores 1 e 2 765/525 kV, garantindo que a abertura destes ocorra após a abertura dos disjuntores de 765 kV de FURNAS..\n(   ) Toda "+

"abertura tripolar dos disjuntores das LTs IVP-LON 1 e 2 de 525 kV, no terminal de Ivaiporã ou Londrina, enviará sinal de disparo para abertura do terminal remoto.\n','3, 2, 1;','1, 3, 2;','2, 1, 3;','2, 3, 1;','1, 2, "+

"3.','','','C',NULL),(80,1,1,1,'Qual a finalidade do Esquema Especial instalado na LT Ivp II 525 kV da subestação Londrina ?','Eliminar as tensões elevadas, em regime, quando da abertura da LT em um dos terminais, permanecendo a linha "+

"energizada a vazio pelo outro terminal.','Eliminar resíduos de MVAr em valores altos na LT. ','Evitar desarme da LT Ivp I 525 kV, por sobrecarga.Assinale a alternativa correta:  ','','','','','A',NULL),(81,16,13,5,'A finalidade da "+

"proteção contra falha de disjuntor é:\n\n','Provocar a abertura do disjuntor falhado.','Garantir a circulação de corrente pelo disjuntor falhado.','Anular a proteção intrínseca do disjuntor falhado possibilitando sua "+

"manobra.','Provocar a abertura dos disjuntores adjacentes a fim de isolar o disjuntor falhado.','Nenhuma das anteriores.','','','D',NULL),(82,17,13,2,'O sistema de proteção com relés diferenciais das linhas STIV baseia-se no princípio "+

"da:','Diferença do nível de tensão.','Comparação de corrente.','Fuga a terra.','Linha morta.','Nenhuma das anteriores.','','','B',NULL),(83,1,13,2,'A proteção diferencial de barra da SE-IVP é composta por:','Um único relé para "+

"proteção das barras A e B.','Conjunto de relés para proteção das barras A e B de modo compartilhado.','Conjunto de relés para proteção das barras A e B individualmente.','Relés digitais com seletividade da barra a proteger.','Nenhuma "+

"das anteriores.','','','C',NULL),(84,17,13,2,'Possuem semelhança nas filosofias de proteção e nos tipo de equipamentos de proteção as linhas:','CVO e ARE.','LON 1 e LON 2.','SSA 2 e STIV 1.','STIV 3 e ARE.','STIV 1 e STIV "+

"2.','','','E',NULL),(85,17,14,4,'A função principal da proteção por relés é:  ','Desligar uma linha que apresente defeito.','Promover a retirada  rápida de serviço do DJ, mais próximo ao defeito. ','Promover uma rápida retirada de "+

"serviço de um elemento do sistema, quando ele sofre curto-circuito ou quando começa a operar de modo anormal que possa causar danos ou interferir com a correta operação do sistema.','Promover a retirada de serviço do elemento "+

"defeituoso, o mais rápido possível, devido à PV.','Todas alternativas estão corretas. ','','','C',NULL),(86,17,14,4,'A função secundária da proteção por relés é:','Promover a indicação da localização do tipo de defeito, visando uma "+

"rápida reparação e possibilidades de análise da eficiência e características da proteção adotada.','Promover a indicação do defeito do elemento causador do curto-circuito. ','Indicar a localização do defeito e isolar o elemento "+

"defeituoso do sistema.','Auxiliar na análise do defeito para a operação em futuras ocorrências.','Todas as alternativas estão incorretas. ','','','A',NULL),(87,1,14,4,'No bay de transferência da SECMO, existe 4 botoeiras destinadas a "+

"interligar os relés de proteção para defeitos fase-fase e fase-terra ou trifásicos aos autotransformadores auxiliares, possibilitando aos relés opções na polarização de tensão. São elas:','BS 1,BS 2, BS 3, BS 4.','21 TS, 21 TSS, 21 "+

"NTS, 21 NT. ','TS 4, TS 6, TS 9, TS 12.','BS 4, BS 6, BS 9, BS 12.','TB 1, TB 4, TB 6, TB 9. ','','','D',NULL),(88,17,14,4,'Qual é a sigla da chave seletora de potencial de fase, na SECMO?\n\n','TD.','PVS. ','BS 12.','43 T.','VS. "+

"','','','E',NULL),(89,17,10,4,'Qual o procedimento do operador para rearme (86 BA e  86 BB)  e recomposição quando houver a atuação da proteção Diferencial de Barras 525 Kv  em Londrina  ?\n\n\n','Calar alarmes e anotar as "+

"sinalizações','Aguardar 3 min. e então rearmar proteção  ','Tentar fechar Dj’s da Barra sem o reset','Somente após inspeção detalhada no local e autorização do COSE','Somente com autorização do chefe de turno ','','','D',NULL),"+

"(90,17,10,1,'Com relação a função de religamento automático da LT IVP-LON2 (monopolar)  quando ela operará religando a linha? \n\n','Quando operar a proteção 59H/59L','Quando operar a proteção Falha DJ.','Quando atuarem as prot. "+

"Instantâneas e para faltas com envolvimento de terra.','Quando operar a prot. Sobrecorrente Direcional de Neutro Temporizada – 67NT','Somente para faltas entre fases   ','','','C',NULL),(91,17,1,1,'Qual procedimento para rearme de "+

"bloqueio por “ Falha DJ 1042”  em Londrina e posterior recomposição pela operação?\n\n','Aguardar 3 min.','Somente com autorização do chefe turno  ','Somente após abertura das CS 1041 e 1043 e autorização do COSE','Rearmar a proteção "+

"imediatamente','Nenhuma alternativa é correta ','','','C',NULL),(92,17,15,4,'Em qual valor de tensão na LT SOS 1, o relé de sobretensão 59, enviará sinal de abertura p/ o DJ 732?','250 kv','265 kv','270 kv','276 "+

"kv','290kv','','','D',NULL),(93,17,15,4,'Qual é a função da botoeira 85 CS?','Efetuar teste de sinal de teleproteção ( Carrier)','Ligar e desligar o relé 79 do  religamento automático.','Enviar sinal de bloqueio de abertura de DJ a "+

"outra extremidade da LT.','Ligar e desligar o sistema Carrier ( teleproteção) da proteção primaria. ','N.D.A','','','D',12),(94,17,15,4,'Qual dos relés não faz parte da proteção secundária?','Relé 67NP','Relé 21-1','Relé 21 N','Relé "+

"67 N','2T3','','','A',12),(95,17,15,4,'Em caso de defeito fora da área protegida pelo relé 21-P, quais são os relés que efetuam o seu bloqueio?\n\n','Relés 79 e 85','Relés 67 N e 21-1','Relés 94B e 2T2','Relés 21S e 85','Relés 68 e "+

"50N','','','D',12),(96,17,1,1,'Relativamente à proteção das linhas STIV-I  e STIV-II 525 Kv da se Ivp, no que se refere ao módulo AAC 51, podemos afirmar que:','Led I aceso indica “Defeito à Terra”, atuação da bobina M1;','Led II "+

"aceso indica “Partida fase A”, atuação da bobina M2;','Led III aceso indica “Partida fase C”, atuação da bobina M3;','Apenas a alternativa “C” está correta;','','','','D',12),(97,17,1,2,'Relativamente à proteção das linhas STIV-I  e "+

"STIV-II 525 Kv da se Ivp, no que se refere às alimentações de corrente contínua dos PPS’s 10 e 20, é correto afirmar que:','No PPS 20 o dj 19 alimenta o “Rearme da sinalização dos módulos AAC51, AAC59, AAC67 e LAC125” proveniente do "+

"PDC-2/dj CB-10','No PPS 10 o dj 9 alimenta o “Conversor LAC133, o rearme de disparo LBC3, 23, 63 e  43” proveniente do PDC-1/dj CB-11','No PPS 20 o dj 11 alimenta o “Rearme o rearme de disparo LCC61, 23, 43, 119, 136 ” proveniente do "+

"PDC-2/dj CB-11. ','','','','','A',12),(98,17,1,2,'Relativamente à proteção das barras A e B 525 Kv da se Ivp, no que se refere às alimentações de corrente contínua, assinale a alternativa correta:','Para o PPS 01/Barra A, vem do dj "+

"Q-78  e para o PPS 02/Barra B, vem do dj Q-79, ambos do Quadro de Distribuição de 125 Vcc.','Para o PPS 01 (Barra A), vem do dj e para o Q-88 para o e para o PPS 02 (Barra B) vem do dj Q- 89, ambos do Quadro de Distribuição de 125 "+

"Vcc.','Os relés de disparo podem ser ativados pela atuação do relé diferencial de qualquer fase, pela atuação de falha de qualquer fase ou pela atuação de falha de qualquer disjuntor referente à barra em questão','As alternativas B e "+

"C estão corretas','','','','D',12),(99,17,8,2,'Na SE IVP, em religamentos automáticos de linhas, o modo de acionamento dos disjuntores pode ser ?','Monofásico, bifásico ','Monofásico, trifásico ','Bifásico, trifásico ','Monofásico, "+

"bifásico, trifásico ','nenhuma das alternativas','','','B',12),(100,17,8,2,'O esquema de teleproteção DUTT, da SE IVP significa:','Transferência direta de disparo com subalcance','Desbloqueio por comparação direcional','Esquema de "+

"fraca alimentação','Bloqueio por oscilação de potencia','Nenhuma das anteriores','','','A',12),(101,17,8,2,'O esquema de teleproteção PUTT, da SE IVP significa:','Bloqueio por oscilação de potência ','Transferência de disparo com "+

"subalcance permissível ','Desbloqueio por comparação direcional','Perda de sincronismo','Nenhuma das anteriores','','','B',12),(102,17,8,5,'O esquema de teleproteção POTT, significa:','Desbloqueio por comparação direcional','Bloqueio "+

"por oscilação de potência ','Transferência de disparo com sobrealcance permissível ','Esquema de fraca alimentação ','Nenhuma das alternativas anteriores','','','C',12),(103,17,9,4,'Com relação aos relés utilizados na Proteção "+

"Diferencial de Barra da SE CMO, assinale aquele que não pertence a este sistema:','Relé diferencial 87B','Relé de Bloqueio 86B','Relé Auxiliar 87 TX','Relé direcional 67N','','','','D',12),(104,17,9,4,'Complete, com o relé correto, o "+

"texto extraído do Sistema de Proteção das LTs de 230 kV da SE CMO:\n\n“Atenção especial deve ser dada a operação do relé ____, pois o mesmo possui duas bandeirolas referentes as suas unidades temporizada e instantânea.\nA informação "+

"deverá ser dada da seguinte forma: \n- Atuou o relé ____ unidade instantânea - (bandeirola da esquerda) \n- Atuou o relé ____ unidade temporizada - (bandeirola da direita)”\n','21P ','67N','51N','87B','','','','B',12),"+

"(105,17,9,4,'Dentre os procedimentos do Operador quando da atuação da Proteção Secundária, assinale abaixo aquele que não condiz com os apontados no Manual:','A)	Reconhecer o alarme no anunciador ou no sistema digital e anotar a "+

"ocorrência e horário da mesma.','B)	Rearmar as bandeirolas dos relés e rearmar o alarme visual no anunciador ou no sistema digital.','C)	Proceder conforme instrução de recomposição do módulo do manual de operação.','Informar o "+

"COT e a Equipe de Proteção.   ','','','','D',12),(106,1,7,2,' Com referencia aos sistemas de operação empregados pela ELETROSUL vimos que o desligamento de terminais de linhas de transmissão protegidas por alguns esquemas de proteção, "+

"depende da operação da proteção em ambos os terminais da linha.  Considerando a Figura  abaixo, cuja linha de transmissão é protegida por um esquema CDD ou POTT.  Caso o terminal B esteja aberto por qualquer razão (linha operando em "+

"vazio) e ocorra um defeito no ponto F1, embora haja a operação da unidade 21PA no terminal A, enviando sinal de desbloqueio para o terminal B, o terminal A não será desligado uma vez que o mesmo não recebeu sinal de desbloqueio "+

"proveniente do terminal B (terminal encontra-se aberto). Buscando-se contornar esta situação, as proteções são dotadas de um recurso denominado:\n\n','Lógica de Eco.  Esta lógica, após decorrido um determinado tempo, manda de volta "+

"para o outro terminal remoto o sinal recebido – daí derivando o nome Eco.  Este sinal ao chegar de volta ao terminal de origem, libera a unidade 21PA para desligamento.','Esta lógica de controle e proteção é denominada proteção de "+

"weak infeed;','Stub, termo em inglês que traduzido para o português seria “TOCO”;','De modo a contornar-se esta situação os terminais de linhas de transmissão são dotados de proteção contra Linha Morta;','nenhuma das alternativas "+

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
