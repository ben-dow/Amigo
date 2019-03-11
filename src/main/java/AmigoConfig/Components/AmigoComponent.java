package AmigoConfig.Components;

import AmigoConfig.AmigoDevice;

public abstract class AmigoComponent {

    AmigoDevice DeviceConnection;

    public AmigoComponent(AmigoDevice DeviceConnection) {
        this.DeviceConnection = DeviceConnection;
    }

    public abstract void NewMidiInput(int StatusCode, int ControlCode, int Velocity);



}
