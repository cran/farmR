# Copyright (C) 2006 International Business Machines and others.
# All Rights Reserved.
# This file is distributed under the Common Public License.

# $Id: Makefile.in 726 2006-04-17 04:16:00Z andreasw $

##########################################################################
#    You can modify this example makefile to fit for your own program.   #
#    Usually, you only need to change the five CHANGEME entries below.   #
##########################################################################

# To compile other examples, either changed the following line, or
# add the argument DRIVER=problem_name to make
DRIVER = driver

# CHANGEME: This should be the name of your executable
EXE = $(DRIVER)

# CHANGEME: Here is the name of all object files corresponding to the source
#           code that you wrote in order to define the problem statement
OBJS =  $(DRIVER).o \
	CbcCompareUser.o \
	CbcSolver2.o \
	CbcSolver3.o \
	ClpQuadInterface.o \
	CbcBranchFollow2.o \
	CbcBranchUser.o \
	CbcBranchLink.o

# CHANGEME: Additional libraries
ADDLIBS =

# CHANGEME: Additional flags for compilation (e.g., include flags)
ADDINCFLAGS =

# CHANGEME: Directory to the sources for the (example) problem definition
# files
SRCDIR = .


##########################################################################
#  Usually, you don't have to change anything below.  Note that if you   #
#  change certain compiler options, you might have to recompile the      #
#  package.                                                              #
##########################################################################

# C++ Compiler command
CXX = g++

# C++ Compiler options
CXXFLAGS = -O3 -fomit-frame-pointer -pipe -DNDEBUG -pedantic-errors -Wimplicit -Wparentheses -Wreturn-type -Wcast-qual -Wall -Wpointer-arith -Wwrite-strings -Wconversion -arch i386 

# additional C++ Compiler options for linking
CXXLINKFLAGS = 

# Directory with COIN header files
COININCDIR = /Users/iracooke/Sources/javawfm_CRAN/farmR/src/depends/coin-Cbc/include/coin

# Directory with COIN libraries
COINLIBDIR = /Users/iracooke/Sources/javawfm_CRAN/farmR/src/depends/coin-Cbc/lib

# Libraries necessary to link with Clp
LIBS = -L$(COINLIBDIR) -lCbc -lCgl -lOsiClp -lOsiCbc -lOsi -lClp -lCoinUtils \
	-lm  \
	`cat /Users/iracooke/Sources/javawfm_CRAN/farmR/src/depends/coin-Cbc/lib/../share/doc/coin/Cgl/cgl_addlibs.txt` \
	`cat /Users/iracooke/Sources/javawfm_CRAN/farmR/src/depends/coin-Cbc/lib/../share/doc/coin/Osi/osi_addlibs.txt` \
	`cat /Users/iracooke/Sources/javawfm_CRAN/farmR/src/depends/coin-Cbc/lib/../share/doc/coin/Clp/clp_addlibs.txt` \
	`cat /Users/iracooke/Sources/javawfm_CRAN/farmR/src/depends/coin-Cbc/lib/../share/doc/coin/CoinUtils/coinutils_addlibs.txt`

# Necessary Include dirs (we use the CYGPATH_W variables to allow
# compilation with Windows compilers)
INCL =  -I`$(CYGPATH_W) $(COININCDIR)` $(ADDINCFLAGS)

# The following is necessary under cygwin, if native compilers are used
CYGPATH_W = echo

# Here we list all possible generated objects or executables to delete them
CLEANFILES = \
	crew.o crew \
	barrier.o barrier \
	driver2.o driver2 \
	driver.o driver \
	dynamic.o dynamic \
	fast0507b.o fast0507b \
	fast0507.o fast0507 \
	gear.o gear \
	hotstart.o hotstart \
	link.o link \
	longthin.o longthin \
	lotsize.o lotsize \
	minimum.o minimum \
	nway.o nway \
	qmip.o qmip \
	qmip2.o qmip2 \
	repeat.o repeat \
	sample1.o sample1 \
	sample2.o sample2 \
	sample3.o sample3 \
	sample4.o sample4 \
	sample5.o sample5 \
	sos.o sos \
	sudoku.o sudoku

all: $(EXE)

.SUFFIXES: .cpp .c .o .obj

$(EXE): $(OBJS)
	bla=;\
	for file in $(OBJS); do bla="$$bla `$(CYGPATH_W) $$file`"; done; \
	$(CXX) $(CXXLINKFLAGS) $(CXXFLAGS) -o $@ $$bla $(ADDLIBS) $(LIBS)

clean:
	rm -rf $(CLEANFILES) $(OBJS)

.cpp.o:
	$(CXX) $(CXXFLAGS) $(INCL) -c -o $@ `test -f '$<' || echo '$(SRCDIR)/'`$<


.cpp.obj:
	$(CXX) $(CXXFLAGS) $(INCL) -c -o $@ `if test -f '$<'; then $(CYGPATH_W) '$<'; else $(CYGPATH_W) '$(SRCDIR)/$<'; fi`

.c.o:
	$(CC) $(CFLAGS) $(INCL) -c -o $@ `test -f '$<' || echo '$(SRCDIR)/'`$<


.c.obj:
	$(CC) $(CFLAGS) $(INCL) -c -o $@ `if test -f '$<'; then $(CYGPATH_W) '$<'; else $(CYGPATH_W) '$(SRCDIR)/$<'; fi`
