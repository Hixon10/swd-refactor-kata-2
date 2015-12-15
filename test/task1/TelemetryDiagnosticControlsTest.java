package task1;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TelemetryDiagnosticControlsTest {
    @Test
    public void testDiagnosticInfoProperty() throws Exception {
        TelemetryDiagnosticControls telemetryDiagnosticControls = new TelemetryDiagnosticControls(new TelemetryClient(), 3);
        telemetryDiagnosticControls.setDiagnosticInfo("some string");
        assertEquals("some string", telemetryDiagnosticControls.getDiagnosticInfo());
    }

    @Test(expected = Exception.class)
    public void testExceptionWhenConnectionIsFailed() throws Exception  {
        TelemetryDiagnosticControls telemetryDiagnosticControls = new TelemetryDiagnosticControls(new TelemetryClientStub(), 3);
        telemetryDiagnosticControls.checkTransmission();
    }

    @Test(expected = Exception.class)
    public void testExceptionWhenRetryLeftIsZero() throws Exception  {
        TelemetryDiagnosticControls telemetryDiagnosticControls = new TelemetryDiagnosticControls(new TelemetryClient(), 0);
        telemetryDiagnosticControls.checkTransmission();
    }
}
