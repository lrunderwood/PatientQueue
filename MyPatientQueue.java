/**
 * A Patient queue implementation using a dynamically-sized circular array.
 * 
 * @author TODO
 */
public class MyPatientQueue{
	// instance variables
	// TODO ATTENTION: CODE NEEDED HERE
	// declare instance variables
	// -----
	Patient Queue[];
	int size;

	// constructor
	public MyPatientQueue() {
		// TODO ATTENTION: CODE NEEDED HERE
		// initialize instance variables
		// -----
		Queue = new Patient[7];
		size = 0;
	}

	// functions
	/**
	 * @return the number of patients in the queue
	 */
	public int size() {
		// TODO ATTENTION: CODE NEEDED HERE
		// return the number of patients in the queue

		return this.size;
		// -----
	}

	/**
	 * add patient to end of queue.
	 * @param p - Patient to add to queue
	 */
	public void enqueue(Patient p) {
		// TODO ATTENTION: CODE NEEDED HERE
		// add patient to end of queue
		// resize array, if needed
		// -----

        //check if queue is full and increase size
        if(this.size == Queue.length) {
            Patient[] newQueue = new Patient[Queue.length*2];

            for(int x = 0; x < Queue.length; x++){
                newQueue[x] = Queue[x];
            }

            Queue = newQueue; //does this work so it no will reference newQueue when I call Queue
        }

       Queue[this.size] = p;

        this.size++;
	}

	/**
	 * remove and return next patient from the queue
	 * @return patient at front of queue, null if queue is empty
	 */
	public Patient dequeue() {
		// TODO ATTENTION: CODE NEEDED HERE
		// remove and return the patient at the head of the queue
		// resize array, if needed

        if(this.size == 0)
           return null;

        //resize array to half capacity
        if(this.size < Queue.length/4 && Queue.length > 7){
            Patient[] newQueue = new Patient[Queue.length/2];

            for(int x = 0; x < this.size; x++){
                newQueue[x] = Queue[x];
            }

            Queue = newQueue;
        }

        Patient p = Queue[0];

        for (int x = 0; x < Queue.length; x++) {
            if (x == this.size - 1) {
                Queue[x] = null;
                break;
            }
            //System.out.println(Queue[x].name+"/n");
            Queue[x] = Queue[x + 1];
        }
        this.size--;
        return p;

        /*
        Patient p = Queue[0];
        for(int x = 0; x < this.size - 1; x++) {
            //if array was full then set last entry to null
            if(x == this.size - 1) {
                Queue[x] = null;
                break;
            }

            Queue[x] = Queue[x+1];
        }
        */

       // this.size--;

		//return p;
		// -----
	}

	/**
	 * return, but do not remove, the patient at index i
	 * @param i - index of patient to return
	 * @return patient at index i, or null if no such element
	 */
	public Patient get(int i) {
		// TODO ATTENTION: CODE NEEDED HERE
		// return, but do not remove, the patient at index i
        Patient p = Queue[i];

		return p;
		// -----
	}

	/**
	 * add patient to front of queue
	 * @param p - patient being added to queue
	 */
	public void push(Patient p) {
		// TODO ATTENTION: CODE NEEDED HERE
		// add Patient p to front of queue
		// resize array, if needed
		// -----
        if(this.size == Queue.length) {
            Patient[] newQueue = new Patient[Queue.length*2];

            for(int x = 0; x < Queue.length; x++){
                newQueue[x] = Queue[x];
            }

            Queue = newQueue; //does this work so it no will reference newQueue when I call Queue
        }

        for(int x = this.size; x > 0; x--){
            Queue[x] = Queue[x-1];
        }
        Queue[0] = p;

        this.size++;

	}

	/**
	 * remove and return patient at index i from queue
	 * @param i - index of patient to remove
	 * @return patient at index i, null if no such element
	 */
	public Patient dequeue(int i) {
		// TODO ATTENTION: CODE NEEDED HERE
		// remove and return Patient at index i from queue
		// shift patients down to fill hole left by removed patient
		// resize array, if needed

        //resize array to half capacity
       // System.out.println("Size: " + this.size);
       // System.out.println("Length: " + Queue.length);
        if(this.size <= Queue.length/4 && Queue.length > 7){
           // System.out.println("In");
            Patient[] newQueue = new Patient[Queue.length/2];

            for(int x = 0; x < this.size; x++){
                newQueue[x] = Queue[x];
            }

            Queue = newQueue;
           // System.out.println("Length: " + Queue.length);
        }

        if(i >= 0 && i < this.size) {
            Patient p = Queue[i];

            for (int x = i; x < Queue.length; x++) {
                if (x == this.size - 1) {
                    Queue[x] = null;
                    break;
                }
                //System.out.println(Queue[x].name+"/n");
                Queue[x] = Queue[x + 1];
            }
            this.size--;
            return p;
        }
        return null;

        /*
        Patient[] newQueue = new Patient[Queue.length];

        if(i >= 0 && i < this.size) {
            Patient p = Queue[i];

            for (int x = 0; x < this.size; x++) {
                if (x != i) {
                    newQueue[x] = Queue[x];
                    System.out.println(Queue[x]);
                }
            }

            Queue = newQueue;
            this.size--;
            return p;
        }
        return null;
		// -----
		*/
	}

}
