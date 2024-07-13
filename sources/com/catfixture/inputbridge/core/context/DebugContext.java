package com.catfixture.inputbridge.core.context;

import android.content.Context;
import com.catfixture.inputbridge.core.debug.D;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

public class DebugContext {
    private final String errorLogPath;
    private OutputStream errorOutputStream;
    private PrintWriter errorPrintWriter;

    public void ClearLog() {
        try {
            this.errorOutputStream = new FileOutputStream(this.errorLogPath);
            this.errorPrintWriter = new PrintWriter(this.errorOutputStream);
        } catch (Exception e) {
            e.printStackTrace();
            D.E("Can't create errout log");
        }
    }

    public OutputStream GetErrorStream() {
        return this.errorOutputStream;
    }

    public PrintWriter GetErrorWriter() {
        return this.errorPrintWriter;
    }

    public DebugContext(Context context) {
        this.errorLogPath = context.getFilesDir() + "/error.log";
        try {
            this.errorOutputStream = context.openFileOutput("error.log", 32768);
            this.errorPrintWriter = new PrintWriter(this.errorOutputStream);
        } catch (Exception e) {
            e.printStackTrace();
            ClearLog();
        }
    }

    public void Terminate() {
        OutputStream outputStream = this.errorOutputStream;
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        PrintWriter printWriter = this.errorPrintWriter;
        if (printWriter != null) {
            printWriter.close();
        }
    }
}
