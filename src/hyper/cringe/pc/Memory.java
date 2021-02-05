package hyper.cringe.pc;

public class Memory {
    private float memory;
    private float frequency;

    public Memory(float memory, float frequency) {
        this.memory = memory;
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return "Memory{" +
                "memory=" + memory +
                ", frequency=" + frequency +
                '}';
    }
//  ------------------------------------------------------------------------

    public Memory copy() {
        return new Memory(this.memory, this.frequency);
    }

//  ------------------------------------------------------------------------

    public float getMemory() {
        return memory;
    }

    public void setMemory(float memory) {
        this.memory = memory;
    }

    public float getFrequency() {
        return frequency;
    }

    public void setFrequency(float frequency) {
        this.frequency = frequency;
    }
}
