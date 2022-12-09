import java.util.IntSummaryStatistics;

/**
 * 
 * HeartTransplant class
 * 
 * @author Ana Paula Centeno
 * @author Haolin (Daniel) Jin
 */
public class HeartTransplant {

    // patient array, each Patient is read from the data file
    private Patient[] patients;

    // SurvivabilityByAge array, each rate is read from data file
    private SurvivabilityByAge survivabilityByAge;

    // SurvivabilityByCause array, each rate is read from data file
    private SurvivabilityByCause survivabilityByCause;

    /*
     * Default constructor
     * Initializes patients to null.
     * Initializes survivabilityByAge to null.
     * Initializes survivabilityByCause to null. 
     */
    public HeartTransplant() {
        patients = null;
        survivabilityByAge = null;
        survivabilityByCause = null;    
        // WRITE YOUR CODE HERE
    }

    /*
     * Returns patients
     */
    public Patient[] getPatients() {
        return patients;
        // WRITE YOUR CODE HERE
     } 

    /*
     * Returns survivabilityByAge
     */
    public SurvivabilityByAge getSurvivabilityByAge() {
        return survivabilityByAge;
        // WRITE YOUR CODE HERE
    }

    /*
     * Returns survivabilityByCause
     */
    public SurvivabilityByCause getSurvivabilityByCause() {
       return survivabilityByCause;
        // WRITE YOUR CODE HERE
    }

    /*
     * 1) Initialize the instance variable patients array with numberOfLines length.
     * 
     * 2) Reads from the command line data file, use StdIn.readInt() to read an integer.
     *    File Format: 
     *      ID, ethnicity, Gender, Age, Cause, Urgency, State of health
     * 
     *    Each line refers to one Patient, all values are integers.
     * 
     */
    public void readPatients (int numberOfLines) {
        patients = new Patient[numberOfLines];
        int id;
        int ethnicity;
        int gender;
        int age;
        int cause;
        int urgency;
        int stateOfHealth;
        for(int i = 0; i < numberOfLines ; i++){
            id = StdIn.readInt();
            ethnicity = StdIn.readInt();
            gender = StdIn.readInt();
            age = StdIn.readInt();
            cause = StdIn.readInt();
            urgency = StdIn.readInt();
            stateOfHealth = StdIn.readInt();
            patients[i] = new Patient(id, ethnicity, gender, age, cause, urgency, stateOfHealth);
        }
    }

    /*
     * 1) Initialize the instance variable survivabilityByAge with a new survivabilityByAge object.
     * 
     * 2) Reads from the command line file to populate the object. 
     *    Use StdIn.readInt() to read an integer and StdIn.readDouble() to read a double.
     * 
     *    File Format: Age YearsPostTransplant Rate
     *    Each line refers to one survivability rate by age.
     * 
     */
    public void readSurvivabilityByAge (int numberOfLines) {
       survivabilityByAge = new SurvivabilityByAge[numberOfLines]; // returns an error, cant convert into array
       int age;
       int years;
       double rate;
       for(int i = 0; i<numberOfLines; i++){
        age = StdIn.readInt();
        years = StdIn.readInt();
        rate = StdIn.readDouble();
        survivabilityByAge[i]= new SurvivabilityByAge(age,years,rate); // this returns an error, constructor is undefined even though its literally called above
       }
        // WRITE YOUR CODE HERE
    }

    /*
     * 1) Initialize the instance variable survivabilityByCause with a new survivabilityByCause object.
     * 
     * 2) Reads from the command line file to populate the object. Use StdIn.readInt() to read an 
     *    integer and StdIn.readDouble() to read a double.
     * 
     *    File Format: Cause YearsPostTransplant Rate
     *    Each line refers to one survivability rate by cause.
     * 
     */
    public void readSurvivabilityByCause (int numberOfLines) {
        survivabilityByCause = new SurvivabilityByCause[numberOfLines]; // returns an error, cant convert into array
       int cause;
       int years;
       for(int i = 0; i<numberOfLines; i++){
        cause = StdIn.readInt();
        years = StdIn.readInt();
        survivabilityByCause[i]= new SurvivabilityByAge(cause,years); // this returns an error, constructor is undefined even though its literally called above
       }
        // WRITE YOUR CODE HERE
    }
    
    /*
     * Returns a Patient array containing the patients, 
     * from the patients array, that have age above the parameter age.
     * 
     * The return array has to be completely full with no empty
     * spots, that is the array size should be equal to the number
     * of Patients with age above the parameter age.
     * 
     * Return null if there is no Patient with age above the 
     * parameter age.
     */ 
    public Patient[] getPatientsWithAgeAbove(int age) {
        int counter = 0;
        int x = 0;
        for(int i = 0; i < patients.length;i++){
            if(patients[i].getAge() >= age) {
                counter++;
            }
        }
        if(counter == 0){
            return null;
        }
        else{
            Patient[] array = new Patient[counter];
            for(int i = 0;i<patients.length;i++){
                if(patients[i].getAge() >= age){
                    array[x] = patients[i];
                    x++;
                }
            }
            return array;
        }
        // WRITE YOUR CODE HERE
    }

    /*
     * Returns a Patient array containing the patients, from the patients array, 
     * that have the heart condition cause equal to the parameter cause.
     * 
     * The return array has to be completely full with no empty
     * spots, that is the array size should be equal to the number
     * of Patients with the heart condition cause equal to the parameter cause.
     * 
     * Return null if there is no Patient with the heart condition cause 
     * equal to the parameter cause.
     */ 
    public Patient[] getPatientsByHeartConditionCause(int cause) {
        int counter = 0;
        int x = 0;
        for(int i = 0; i < patients.length;i++){
            if(patients[i].getCause() == cause) {
                counter++;
            }
        }
        if(counter == 0){
            return null;
        }
        else{
            Patient[] array = new Patient[counter];
            for(int i = 0;i<patients.length;i++){
                if(patients[i].getCause() == cause){
                    array[x] = patients[i];
                    x++;
                }
            }
            return array;
        }
        // WRITE YOUR CODE HERE
    }

    /*
     * Returns a Patient array containing patients, from the patients array,
     * that have the state of health equal to the parameter state.
     * 
     * The return array has to be completely full with no empty
     * spots, that is the array size should be equal to the number
     * of Patients with the state of health equal to the parameter state.
     * 
     * Return null if there is no Patient with the state of health 
     * equal to the parameter state.
     */ 
    public Patient[] getPatientsByUrgency(int urgency) {
        int counter = 0;
        int x = 0;
        for(int i = 0; i < patients.length;i++){
            if(patients[i].getStateOfHealth() == urgency) {
                counter++;
            }
        }
        if(counter == 0){
            return null;
        }
        else{
            Patient[] array = new Patient[counter];
            for(int i = 0;i<patients.length;i++){
                if(patients[i].getStateOfHealth() == urgency){
                    array[x] = patients[i];
                    x++;
                }
            }
            return array;
        }
        // WRITE YOUR CODE HERE
    }

    /*
     * Assume there is a heart available for transplantation surgery.
     * Also assume that the heart is of the same blood type as the
     * Patients on the patients array.
     * This method finds the Patient to be the recepient of this
     * heart.
     * 
     * The method returns a Patient from the patients array with
     * he highest potential for survivability after the transplant.
     * 
     * Assume the patient returned by this method will receive a heart,
     * therefore the Patient will no longer need a heart.
     * 
     * There is no correct solution, you may come up with any 
     * function to find the patient with the highest potential 
     * for survivability after the transplant.
     */ 
    public Patient getPatientForTransplant () {
    
	// WRITE YOUR CODE HERE
	return null;
    }
}
