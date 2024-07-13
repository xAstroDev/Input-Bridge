package com.catfixture.inputbridge.ui.activity.main.fragments.sensorsSettings.TinyRender;

public class EmbeddedShaders {
    public static final String FragmentShaderCode = "precision mediump float;uniform vec4 vColor;uniform mat4 matrixV;uniform mat4 matrixP;uniform mat4 matrixM;varying vec2 v_texCoords;varying vec3 v_Normal;varying vec3 FragPos;void main() {  vec3 wsNormr = -normalize(vec3(matrixV*vec4(v_Normal,1.0f)));  vec3 lightDir = normalize(vec3(0.5f,0.5f,0.5f));  float intensity = max(dot(wsNormr, lightDir),0.0f);  gl_FragColor = vec4(vec3(intensity + 0.2f),1);}";
    public static final String UnlitFShader = "precision mediump float;uniform vec3 color;void main() {  gl_FragColor = vec4(color,1);}";
    public static final String UnlitVShader = "uniform mat4 matrixV;uniform mat4 matrixP;uniform mat4 matrixM;attribute vec3 vPosition;void main() {  gl_Position = matrixP * matrixV * matrixM * vec4(vPosition,1.0);}";
    public static final String VertexShaderCode = "uniform mat4 matrixV;uniform mat4 matrixP;uniform mat4 matrixM;attribute vec3 vPosition;attribute vec3 vNormal;attribute vec2 a_texCoord0;varying vec2 v_texCoords;varying vec3 v_Normal;varying vec3 FragPos;void main() {  gl_Position = matrixP * matrixV * matrixM * vec4(vPosition,1.0);  FragPos = vec3(matrixM * vec4(vPosition, 1.0));  v_texCoords = a_texCoord0;  v_Normal = vNormal;}";
}
