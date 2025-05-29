Imagine uma aplicacao que interaja com o serviço de SMS de
operadoras de celular.

Considere que a vers˜ao inicial da aplicaçao possua uma interface
para interagir com o servi¸co de apenas uma operadora.

figura a seguir apresenta a interface SMSSender que é utilizada
pela aplicaçao para o envio de mensagens de sms's.

    public interface SMSsender{
        public boolean sendSMS(SMS sms)
    }

    public class SMS{
        private string destino;
        private string origem;
        private string texto;
    }

Essa classe possui o metodo sendSMS() que recebe como
parametro uma instancia da classe SMS, tambem apresentada na
figura, e retorna um valor booleano dizendo se a mensagem foi
enviada com sucesso ou nao.


Ao evoluir a aplicacao, foi necess´ario incorporar o servico de envio
de mensagens de uma outra operadora.

    public interface EnviadorSMS{
        public void enviarSMS(String destino,String origem,String[] msgs) throwsSMSException;
    }

A primeira diferença está nos parâmetros, que, em vez de serem encapsulados em uma classe — no caso, a SMS —, são passados diretamente para o método.
Outra diferença é que o texto da mensagem não é mais uma string, mas sim um array de strings.
Na primeira API, um texto longo era recebido e, se necessário, dividido em várias mensagens. Já na nova API, a mensagem precisa ser dividida em trechos de até 160 caracteres antes da chamada do método.
Por fim, a nova API lança uma exceção para indicar uma falha, em vez de retornar um valor booleano para indicar sucesso ou erro.

Para evitar que as classes cliente precisem ser alteradas e se
acoplarem a uma nova API, decidiu-se criar um Adapter para
traduzir as chamadas de uma interface para outra

Implemente o padrao Adapter para o problema proposto.