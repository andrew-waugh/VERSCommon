/*
 * Copyright Public Record Office Victoria 2015
 * Licensed under the CC-BY license http://creativecommons.org/licenses/by/3.0/au/
 * Author Andrew Waugh
 * Version 1.0 February 2015
 */
package VERSCommon;

/**
 * This class represents a non fatal error produced when constructing a VEO.
 * This VEO should be aborted and cleaned up, but further VEOs may be attempted.
 */
public class VEOError extends Exception {

    int errno;  // error number for automated processing

    /**
     * Construct a new VEOError with appropriate error message.
     * This constructor should be used when it is not feasible to test if this
     * error has occurred (e.g. an obscure exception is thrown).
     * @param s the error message to return
     */
    public VEOError(String s) {
        super(s);
        errno = -1;
    }

    /**
     * Construct a new VEOError from a class constructor giving error number.
     * This constructor should be used when it is desired to test that this
     * error is handled correctly.
     * @param errno unique error number
     * @param s error message
     */
    public VEOError(int errno, String s) {
        super(s);
        this.errno = errno;
    }

    /**
     * Construct a new VEOError from a class constructor giving error number
     *
     * @param classname name of class generating error
     * @param errno unique error number
     * @param s error message
     */
    public VEOError(String classname, int errno, String s) {
        super(s + " (" + classname + ")");
        this.errno = errno;
    }

    /**
     * Construct a new VEOError from a particular method giving error number
     *
     * @param classname name of class generating error
     * @param method name of method in which error occurred
     * @param errno unique error number
     * @param s error message
     */
    public VEOError(String classname, String method, int errno, String s) {
        super(s + " (" + classname + "." + method + "())");
        this.errno = errno;
    }

    /**
     * Gets the error identifier to uniquely identify the error.
     *
     * @return the error number
     */
    public int getId() {
        return errno;
    }
}
