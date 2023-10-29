package br.com.erudio.math;

public class SimpleMath {
	
		public Double sum(Double numberOne, Double numberTwo) {
			return numberOne + numberTwo;
		}
		
		
		public Double sub(Double numberOne, Double numberTwo) {
			return numberOne - numberTwo;
		}
		
		
		public Double mult(Double numberOne, Double numberTwo) {
			return numberOne * numberTwo;
		}
		
		
		public Double diff(Double numberOne, Double numberTwo) {
			return numberOne / numberTwo;
		}
		
		
		public Double mean(Double numberOne, Double numberTwo){
			return (numberOne + numberTwo) / 2;
		}
		
		
		public Double raiz(Double numberOne) {
			Double raizQuadrada = (double)Math.sqrt(numberOne);
			return raizQuadrada;
		}
}
