package main.StructuralPattern.AdapterDesignPattern;


// Interface for power source (client expects 110V)
interface USAPowerSocket {
    int provide110V();
}

// European device expecting 220V
class EuropeanElectricalDevice {
    public void plugIn(int voltage) {
        if (voltage == 220) {
            System.out.println("Device running on 220V.");
        } else {
            System.out.println("Voltage mismatch! Device cannot run.");
        }
    }
}

// US socket providing only 110V
class USAPowerOutlet implements USAPowerSocket {
    public int provide110V() {
        return 110;
    }
}

// Adapter converts 110V from US socket to 220V for European device
class PowerAdapter {
    USAPowerSocket usSocket;

    public PowerAdapter(USAPowerSocket socket) {
        this.usSocket = socket;
    }

    // Converts 110V to 220V (simulated)
    public int provide220V() {
        int voltage = usSocket.provide110V();
        // Simulate voltage step-up conversion
        return voltage * 2;
    }
}

public class AdapterDesignPatternExample {
    public static void main(String[] args) {
        USAPowerOutlet usSocket = new USAPowerOutlet();
        PowerAdapter adapter = new PowerAdapter(usSocket);
        EuropeanElectricalDevice device = new EuropeanElectricalDevice();

        // Adapter converts voltage making it compatible
        device.plugIn(adapter.provide220V());  // Device running on 220V.
    }
}