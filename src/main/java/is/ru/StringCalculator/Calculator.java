package is.ru.StringCalculator;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		else if(text.contains(",") || text.contains("\n")){
			return sum(splitNumbers(text));
		}
		else
			return 1;
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
		if(numbers.startsWith("//")){
			if(!numbers.startsWith("//\n")){
				String[] splitted = numbers.split("\n", 2);
				String[] del = splitted[0].split("");
				String delimiter = del[2];
				return splitted[1].split(delimiter);
			}
			;
			String ret = numbers.replace("//\n\n", "");
			return	ret.split("\n");
		}
		else
			return numbers.split(",|\n");
	}
      
    private static int sum(String[] numbers){
 	    int total = 0;
 	    String fail = "“Negatives not allowed: ";
 	    int checker = 0;
        for(String number : numbers){
        	int sum = toInt(number);
        	if(sum < 0){
        		if(checker > 0){
        			fail += ", ";
        		}
        		fail += sum;
        		checker++;
        	}

		    total += sum;
		}
		if(checker > 0){
			throw new IllegalArgumentException(fail);
		}
		return total;
    }



}