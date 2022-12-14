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
        int id = 0 ;
        int ethnicity = 0;
        int gender = 0;
        int age = 0;
        int cause = 0;
        int urgency = 0;
        int stateOfHealth = 0;
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
    this.survivabilityByAge = new SurvivabilityByAge(); 
       int years = 0 ;
       int age = 0 ;
       double rate = 0.0;
       for(int i = 0; i<numberOfLines; i++){
        age = StdIn.readInt();
        years = StdIn.readInt();
        rate = StdIn.readDouble();
        this.survivabilityByAge.addData(age, years, rate);
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
       this.survivabilityByCause = new SurvivabilityByCause(); 
       int cause = 0;
       int years = 0;
       double rate = 0.0;
       for(int i = 0; i<numberOfLines; i++){
        cause = StdIn.readInt();
        years = StdIn.readInt();
        rate = StdIn.readDouble();
        this.survivabilityByCause.addData(cause, years, rate);
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
        int count = 0;
        for(int i = 0; i < patients.length; i++){
            if(patients[i].getAge() >= age)
            count++;
        }

        if(count == 0)
            return null;
        else{
            Patient[] array = new Patient[count];
            int index = 0;
            for(int i = 0; i < patients.length; i++){
                if(patients[i].getAge() >= age){
                    array[index] = patients[i];
                    index++;
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
        int count = 0;
        for(int i = 0; i < patients.length; i++){
            if(patients[i].getCause() == cause)
            count++;
        }

        if(count == 0){
            return null;
        }
        else{
            Patient[] array = new Patient[count];
            int index = 0;
            for(int i = 0; i < patients.length; i++){
                if(patients[i].getCause() == cause){
                    array[index] = patients[i];
                    index++;
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
            int counter = 0;
            double x = 0;
            for(int i = 0; i < patients.length; i++){
                if(patients[i].getNeedHeart() == true && patients[i].getUrgency() == 9){
                double survivabilityRate = this.getSurvivabilityByAge().getRate(patients[i].getAge(), 5) + this.getSurvivabilityByCause().getRate(patients[i].getCause(), 5);
                survivabilityRate /= 2;
                if(survivabilityRate > x){
                    x = survivabilityRate;
                    counter = i;
                }
                }
            }
            patients[counter].setNeedHeart(false);
            return patients[counter];
        }
    }
