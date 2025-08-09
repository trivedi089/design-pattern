package main.StructuralPattern.AdapterDesignPattern;


// Interface for power source (client expects 110V)
interface USPowerSocket {
    int provide110V();
}

// European device expecting 220V
class EuropeanDevice {
    public void plugIn(int voltage) {
        if (voltage == 220) {
            System.out.println("Device running on 220V.");
        } else {
            System.out.println("Voltage mismatch! Device cannot run.");
        }
    }
}

// US socket providing only 110V
class USPowerOutlet implements USPowerSocket {
    public int provide110V() {
        return 110;
    }
}

public class WithoutAdapterDesign {
    public static void main(String[] args) {
        USPowerOutlet usSocket = new USPowerOutlet();
        EuropeanDevice device = new EuropeanDevice();

        // Direct connection fails because device expects 220V
        device.plugIn(usSocket.provide110V());  // Voltage mismatch! Device cannot run.
    }
}
