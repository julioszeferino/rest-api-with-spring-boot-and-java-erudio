package br.com.erudio.converters;

public class NumberConverter {
	
	public static Double convertToDouble(String strNumber) {
		if (strNumber == null) {
			return 0D;
		}
		// tratando para aceitar 10,25 ou 10.25
		String number = strNumber.replaceAll(",", ".");
		
		if(isNumeric(number)) {
			return Double.parseDouble(number);
		}
		return 0D;
	}


	public static boolean isNumeric(String strNumber) {
		if (strNumber == null) {
			return false;
		}
		// tratando para aceitar 10,25 ou 10.25
		String number = strNumber.replaceAll(",", ".");
		// verificando se e um numero usando regex
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
}
