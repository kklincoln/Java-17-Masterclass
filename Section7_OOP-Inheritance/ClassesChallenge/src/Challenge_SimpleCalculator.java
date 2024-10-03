public class Challenge_SimpleCalculator {
        // write code here
        private double firstNumber;
        private double secondNumber;


        //getter functions
        public double getFirstNumber(){
            return this.firstNumber;
        }
        public double getSecondNumber(){
            return this.secondNumber;
        }

        //setter functions
        public void setFirstNumber(double firstNumber){
            this.firstNumber = firstNumber;
        }
        public void setSecondNumber(double secondNumber){
            this.secondNumber = secondNumber;
        }
        //, it needs to return the result of adding the field values of firstNumber and secondNumber.
        public double getAdditionResult(){
            return firstNumber + secondNumber;
        }
        //it needs to return the result of subtracting the field values of secondNumber from the firstNumber.
        public double getSubtractionResult(){
            return firstNumber - secondNumber;
        }
        // it needs to return the result of multiplying the field values of firstNumber and secondNumber
        public double getMultiplicationResult(){
            return firstNumber * secondNumber;
        }
        //it needs to return the result of dividing the field values of firstNumber by the secondNumber. In case the value of secondNumber is 0 then return 0.
        public double getDivisionResult(){
            if(secondNumber == 0.0){
                return 0.00;

            }
            else{
                return firstNumber / secondNumber;
            }
        }
    }

