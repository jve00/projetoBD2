package projetobdII.biblioteca.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class RegraNegocioException extends Exception{
    public RegraNegocioException(String message){
        super(message);
    }
}
