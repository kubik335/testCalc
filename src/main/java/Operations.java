/**
 * Created by Alexandra Kolpakova on 28.07.2018.
 */
public class Operations {

    public double getResult(int val1, int val2, OperationsTypes operationsTypes) {
        int result;
        switch (operationsTypes) {
            case ADDITION:
                result = val1 + val2;
                break;
            case SUBTRACTION:
                result = val1 - val2;
                break;
            case MULTIPLICATION:
                result = val1 * val2;
                break;
            case DIVISION:
                result = val1 / val2;
                break;
            default:
                result = val1 + val2;
                break;
        }
        return result;
    }

    public enum OperationsTypes {
        ADDITION ("ADDITION"),
        SUBTRACTION ("SUBTRACTION"),
        MULTIPLICATION ("MULTIPLICATION"),
        DIVISION ("DIVISION");

        private final String type;

        OperationsTypes(String type){
            this.type = type;
        }

        public String getType(){
            return this.type;
        }
    }
}
