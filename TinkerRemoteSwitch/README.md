Alright. This is my first Tinkerforge project outside the usual hands-on stuff you get to do during workshops and conferences.

My sister-in-law got me the IoT-kit off Tinkerforge so I can control my remote controlled socket outlets through some silicon. I have a set of mumbi FS-300 which are, according to the [bricklet documentation](http://www.tinkerforge.com/en/doc/Hardware/Bricklets/Remote_Switch.html#list-of-supported-devices), compatible with the RemoteSwitch bricklet. However, it seems to be _impossible_ to find out the house and receiver codes for them, so I figured I would just loop through all possible codes (which appear to be, for type A receivers, 2^5 x 2^5 combinations) and find the workable combinations that way - just note the combination when you hear the switch's relay go clack. 

As a side effect, it's possible to switch off (or on) all the 433 MHz devices in range ;)

March 2015
CC-BY-SA hiergiltdiestfu