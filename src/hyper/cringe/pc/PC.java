package hyper.cringe.pc;

import java.util.Arrays;

public class PC {
    private String title;
    private CPU cpu;
    private GPU gpu;
    private Memory[] memoryBlocks;

    public PC(String title, CPU cpu, GPU gpu, Memory[] memoryBlocks) {
        this.title = title;
        this.cpu = cpu;
        this.gpu = gpu;
        this.memoryBlocks = memoryBlocks;
    }

    public PC(String title, CPU cpu, GPU gpu, int memoryBlocksQuantity) {
        this(title, cpu, gpu, new Memory[memoryBlocksQuantity]);
    }

    @Override
    public String toString() {
        return "PC { title=" + title +
                "\ncpu=" + cpu +
                ",\ngpu=" + gpu +
                ",\nmemoryBlocks=" + Arrays.toString(memoryBlocks) +
                "\n}";
    }



//  ------------------------------------------------------------------------

    public float getRating() {
        return this.cpu.getMaxFrequency() * (float) 0.95 +
                this.cpu.getCores() +
                this.gpu.getMemory() * (float) 0.2 +
                (this.gpu.isRtx() ? 1 : 0);
    }

    public PC copy() {
        return new PC(this.title, this.cpu.copy(), this.gpu.copy(), Arrays.copyOf(memoryBlocks, memoryBlocks.length));
    }

//  ------------------------------------------------------------------------

    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public GPU getGpu() {
        return gpu;
    }

    public void setGpu(GPU gpu) {
        this.gpu = gpu;
    }

    public Memory[] getMemoryBlocks() {
        return memoryBlocks;
    }

    public void setMemoryBlocks(Memory[] memoryBlocks) {
        this.memoryBlocks = memoryBlocks;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
