package com.catfixture.inputbridge.core.inputbridge;

import com.catfixture.inputbridge.core.debug.D;
import com.catfixture.inputbridge.core.utils.types.Event;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.util.Timer;
import java.util.TimerTask;

public abstract class FastPipe implements IPipe {
    private final ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
    /* access modifiers changed from: private */
    public InetAddress clientAddr;
    /* access modifiers changed from: private */
    public int clientPort;
    private boolean isRunning;
    /* access modifiers changed from: private */
    public final Event onAlive = new Event();
    /* access modifiers changed from: private */
    public final Event onDataReceived = new Event();
    private final int port;
    private Timer receiverTimer;
    private Timer senderTimer;
    /* access modifiers changed from: private */
    public DatagramSocket socket;
    private final int targetFramerate;

    public abstract void RequestWrite();

    public void SetTargetRate(int i) {
    }

    public Event OnDataReceived() {
        return this.onDataReceived;
    }

    public Event OnAlive() {
        return this.onAlive;
    }

    /* access modifiers changed from: protected */
    public int Size() {
        return this.byteBuffer.position();
    }

    /* access modifiers changed from: protected */
    public byte[] Compile() {
        byte[] array = this.byteBuffer.array();
        this.byteBuffer.clear();
        return array;
    }

    public FastPipe(int i, int i2) {
        this.port = i;
        this.targetFramerate = i2;
    }

    public void Start() {
        if (this.receiverTimer == null && this.senderTimer == null) {
            try {
                final byte[] bArr = new byte[1024];
                this.socket = new DatagramSocket(this.port);
                this.isRunning = true;
                Timer timer = new Timer("FastPipe TX " + this.port);
                this.senderTimer = timer;
                timer.scheduleAtFixedRate(new TimerTask() {
                    public void run() {
                        synchronized (Marshall.globalMutex) {
                            FastPipe.this.RequestWrite();
                            int Size = FastPipe.this.Size();
                            if (Size > 0) {
                                DatagramPacket datagramPacket = new DatagramPacket(FastPipe.this.Compile(), Size);
                                if (FastPipe.this.clientAddr != null) {
                                    datagramPacket.setAddress(FastPipe.this.clientAddr);
                                    datagramPacket.setPort(FastPipe.this.clientPort);
                                    datagramPacket.setLength(Size);
                                    try {
                                        FastPipe.this.socket.send(datagramPacket);
                                        FastPipe.this.onAlive.notifyObservers();
                                    } catch (SocketException unused) {
                                    } catch (Exception e) {
                                        D.E((Throwable) e);
                                    }
                                }
                            }
                        }
                    }
                }, 0, (long) (1000 / this.targetFramerate));
                Timer timer2 = new Timer("FastPipe RX " + this.port);
                this.receiverTimer = timer2;
                timer2.schedule(new TimerTask() {
                    public void run() {
                        byte[] bArr = bArr;
                        DatagramPacket datagramPacket = new DatagramPacket(bArr, bArr.length);
                        try {
                            FastPipe.this.socket.receive(datagramPacket);
                        } catch (IOException unused) {
                        }
                        FastPipe.this.onDataReceived.notifyObservers(datagramPacket);
                        int unused2 = FastPipe.this.clientPort = datagramPacket.getPort();
                        InetAddress unused3 = FastPipe.this.clientAddr = datagramPacket.getAddress();
                    }
                }, 0, (long) (1000 / this.targetFramerate));
            } catch (SocketException unused) {
            } catch (Exception e) {
                D.E((Throwable) e);
            }
        }
    }

    public void Stop() {
        Timer timer = this.receiverTimer;
        if (timer != null) {
            timer.cancel();
            this.receiverTimer.purge();
        }
        Timer timer2 = this.senderTimer;
        if (timer2 != null) {
            timer2.cancel();
            this.senderTimer.purge();
        }
        this.receiverTimer = null;
        this.senderTimer = null;
        try {
            this.socket.close();
        } catch (Exception unused) {
        }
        this.isRunning = false;
    }

    public IPipe Write(byte b) {
        this.byteBuffer.put(b);
        return this;
    }

    public IPipe Write(int i) {
        this.byteBuffer.put(BitUtil.IntToByteArray(i));
        return this;
    }

    public IPipe Write(float f) {
        this.byteBuffer.put(BitUtil.FloatToByteArray(f));
        return this;
    }

    public IPipe Write(XIState xIState) {
        this.byteBuffer.put(BitUtil.ShortToByteArray(xIState.buttons));
        this.byteBuffer.put(xIState.leftTrigger);
        this.byteBuffer.put(xIState.rightTrigger);
        this.byteBuffer.put(BitUtil.ShortToByteArray(xIState.thumbLX));
        this.byteBuffer.put(BitUtil.ShortToByteArray(xIState.thumbLY));
        this.byteBuffer.put(BitUtil.ShortToByteArray(xIState.thumbRX));
        this.byteBuffer.put(BitUtil.ShortToByteArray(xIState.thumbRY));
        return null;
    }
}
