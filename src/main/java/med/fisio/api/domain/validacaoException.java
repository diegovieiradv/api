package med.fisio.api.domain;

public class validacaoException extends RuntimeException {
    public validacaoException(String mensagem) {
        super(mensagem);
    }
}
