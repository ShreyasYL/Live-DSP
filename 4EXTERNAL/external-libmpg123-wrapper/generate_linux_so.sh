if [ -z "$JAVA_HOME" ]; then
	echo Please set your JAVA_HOME environment variable to proceed
	echo
	echo Fail.
	exit 1;
fi

export SWIGDIR=swig
export LIBDIR=lib
export JAVAOUTDIR=src/uk/co/modularaudio/libmpg123wrapper/swig
export PACKAGE=uk.co.modularaudio.libmpg123wrapper.swig

echo Cleaning working files
rm -f ${SWIGDIR}/libmpg123_wrap.c
rm -f ${LIBDIR}/libmpg123_wrap.so
rm -f ${LIBDIR}/libmpg123_wrap.o
rm -f ${LIBDIR}/libmpg123_jnibulk.o
rm -rf ${JAVAOUTDIR}
echo done
echo

mkdir -p ${JAVAOUTDIR}
mkdir -p ${LIBDIR}

echo Generating Shared Library Source File
swig -I/usr/include -java -package ${PACKAGE} -outdir ${JAVAOUTDIR} ${SWIGDIR}/libmpg123.i
echo Generating Shared Library Wrapper object
gcc -fpic -I$JAVA_HOME/include -I$JAVA_HOME/include/linux -c ${SWIGDIR}/libmpg123_wrap.c -o ${LIBDIR}/libmpg123_wrap.o
echo Generating Custom Bulk Transfer Method Object
gcc -fpic -I$JAVA_HOME/include -I$JAVA_HOME/include/linux -c ${SWIGDIR}/libmpg123_jnibulk.c -o ${LIBDIR}/libmpg123_jnibulk.o
echo Generating Shared Library Wrapper SO
gcc -shared -o ${LIBDIR}/libmpg123_wrap.so ${LIBDIR}/libmpg123_wrap.o ${LIBDIR}/libmpg123_jnibulk.o -L/usr/local/lib -lmpg123
echo done
echo
