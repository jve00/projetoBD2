package br.edu.ifpb.mt.dac.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class RegraNegocioException extends Exception{
    public RegraNegocioException(String message){
        super(message);
    }
}
