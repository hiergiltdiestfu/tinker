package info.hiergiltdiestfu.tinker.remoteswitch;

import com.tinkerforge.BrickletRemoteSwitch;
import com.tinkerforge.IPConnection;

public class AllSocketsOff {

	private static final String HOST = "localhost";
    private static final int PORT = 4223;
    private static final String UID = "rMw"; 

	
	public static void main(String[] args) throws Exception {

		IPConnection ipcon = new IPConnection(); // Create IP connection
        BrickletRemoteSwitch rs = new BrickletRemoteSwitch(UID, ipcon); // Create device object

        ipcon.connect(HOST, PORT); // Connect to brickd
        // Don't use device before ipcon is connected
        
        rs.setRepeats((short) 5);
        
        long start = System.currentTimeMillis();
        long lastCombi = start;
        long tooks = 0;
        
        for (short houseCode = 0; houseCode <= 31; houseCode++) {
			for (short receiverCode = 0; receiverCode <= 31; receiverCode++) {
				System.out.print("house: "+houseCode+"; rcv: "+receiverCode);
				rs.switchSocketA(houseCode, receiverCode, BrickletRemoteSwitch.SWITCH_TO_OFF);
				
				while(rs.getSwitchingState() == BrickletRemoteSwitch.SWITCHING_STATE_BUSY) {
					System.out.print(".");
					Thread.sleep(10);
				}
				long took = System.currentTimeMillis()-lastCombi;
				tooks += took;
				int done = (houseCode*32)+(receiverCode);
				String rem = String.format("%.3f", (1024 - done) * ((double)tooks/done/1000));
				System.out.println(" (Took: "+took+" ms; remaining: "+rem+" seconds)");
				lastCombi = System.currentTimeMillis();
			}
		}
        
        long stop = System.currentTimeMillis();
        System.out.println("Total time: "+(stop-start)+"ms");
		
	}

}
