package br.com.melpetspa.melpetspa.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    public static boolean isCpfValid(String cpf) {
        // Remove qualquer caracter que não seja número
        cpf = cpf.replaceAll("[^0-9]", "");

        // Verifica se o CPF tem 11 dígitos
        if (cpf.length() != 11) {
            return false;
        }

        // Verifica se o CPF é uma sequência repetida (ex: 111.111.111-11)
        if (cpf.equals(cpf.charAt(0) + String.valueOf(cpf.charAt(0)).repeat(10))) {
            return false;
        }

        // Verifica o primeiro dígito verificador
        int sum1 = 0;
        for (int i = 0; i < 9; i++) {
            sum1 += (cpf.charAt(i) - '0') * (10 - i);
        }
        int digit1 = 11 - (sum1 % 11);
        if (digit1 >= 10) digit1 = 0;

        // Verifica o segundo dígito verificador
        int sum2 = 0;
        for (int i = 0; i < 10; i++) {
            sum2 += (cpf.charAt(i) - '0') * (11 - i);
        }
        int digit2 = 11 - (sum2 % 11);
        if (digit2 >= 10) digit2 = 0;

        // Compara os dígitos verificadores
        return cpf.charAt(9) == (char) ('0' + digit1) && cpf.charAt(10) == (char) ('0' + digit2);
    }

    public static boolean isValidEmail(String email) {
        // Regex para validar o e-mail
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        // Criando o Pattern a partir da regex
        Pattern pattern = Pattern.compile(emailRegex);

        // Verificando se o e-mail corresponde ao padrão
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();  // Retorna true se o e-mail for válido
    }
}
