// This file contains helper functions that are automatically created from
// templates.

#include "nuitka/prelude.h"

extern PyObject *callPythonFunction( PyObject *func, PyObject **args, int count );


PyObject *CALL_FUNCTION_WITH_ARGS1( PyObject *called, PyObject **args )
{
    CHECK_OBJECT( called );

    // Check if arguments are valid objects in debug mode.
#ifndef __NUITKA_NO_ASSERT__
    for( size_t i = 0; i < 1; i++ )
    {
        CHECK_OBJECT( args[ i ] );
    }
#endif

    if ( Nuitka_Function_Check( called ) )
    {
        if (unlikely( Py_EnterRecursiveCall( (char *)" while calling a Python object" ) ))
        {
            return NULL;
        }

        struct Nuitka_FunctionObject *function = (struct Nuitka_FunctionObject *)called;
        PyObject *result;

        if ( function->m_args_simple && 1 == function->m_args_positional_count )
        {
            for( Py_ssize_t i = 0; i < 1; i++ )
            {
                Py_INCREF( args[ i ] );
            }

            result = function->m_c_code( function, args );
        }
        else if ( function->m_args_simple && 1 + function->m_defaults_given == function->m_args_positional_count )
        {
#ifdef _MSC_VER
            PyObject **python_pars = (PyObject **)_alloca( sizeof( PyObject * ) * function->m_args_positional_count );
#else
            PyObject *python_pars[ function->m_args_positional_count ];
#endif
            memcpy( python_pars, args, 1 * sizeof(PyObject *) );
            memcpy( python_pars + 1, &PyTuple_GET_ITEM( function->m_defaults, 0 ), function->m_defaults_given * sizeof(PyObject *) );

            for( Py_ssize_t i = 0; i < function->m_args_positional_count; i++ )
            {
                Py_INCREF( python_pars[ i ] );
            }

            result = function->m_c_code( function, python_pars );
        }
        else
        {
#ifdef _MSC_VER
            PyObject **python_pars = (PyObject **)_alloca( sizeof( PyObject * ) * function->m_args_overall_count );
#else
            PyObject *python_pars[ function->m_args_overall_count ];
#endif
            memset( python_pars, 0, function->m_args_overall_count * sizeof(PyObject *) );

            if ( parseArgumentsPos( function, python_pars, args, 1 ))
            {
                result = function->m_c_code( function, python_pars );
            }
            else
            {
                result = NULL;
            }
        }

        Py_LeaveRecursiveCall();

        return result;
    }
    else if ( Nuitka_Method_Check( called ) )
    {
        struct Nuitka_MethodObject *method = (struct Nuitka_MethodObject *)called;

        // Unbound method without arguments, let the error path be slow.
        if ( method->m_object != NULL )
        {
            if (unlikely( Py_EnterRecursiveCall( (char *)" while calling a Python object" ) ))
            {
                return NULL;
            }

            struct Nuitka_FunctionObject *function = method->m_function;

            PyObject *result;

            if ( function->m_args_simple && 1 + 1 == function->m_args_positional_count )
            {
#ifdef _MSC_VER
                PyObject **python_pars = (PyObject **)_alloca( sizeof( PyObject * ) * function->m_args_positional_count );
#else
                PyObject *python_pars[ function->m_args_positional_count ];
#endif
                python_pars[ 0 ] = method->m_object;
                Py_INCREF( method->m_object );

                for( Py_ssize_t i = 0; i < 1; i++ )
                {
                    python_pars[ i + 1 ] = args[ i ];
                    Py_INCREF( args[ i ] );
                }

                result = function->m_c_code( function, python_pars );
            }
            else if ( function->m_args_simple && 1 + 1 + function->m_defaults_given == function->m_args_positional_count )
            {
#ifdef _MSC_VER
                PyObject **python_pars = (PyObject **)_alloca( sizeof( PyObject * ) * function->m_args_positional_count );
#else
                PyObject *python_pars[ function->m_args_positional_count ];
#endif
                python_pars[ 0 ] = method->m_object;
                Py_INCREF( method->m_object );

                memcpy( python_pars+1, args, 1 * sizeof(PyObject *) );
                memcpy( python_pars+1 + 1, &PyTuple_GET_ITEM( function->m_defaults, 0 ), function->m_defaults_given * sizeof(PyObject *) );

                for( Py_ssize_t i = 1; i < function->m_args_overall_count; i++ )
                {
                    Py_INCREF( python_pars[ i ] );
                }

                result = function->m_c_code( function, python_pars );
            }
            else
            {
#ifdef _MSC_VER
                PyObject **python_pars = (PyObject **)_alloca( sizeof( PyObject * ) * function->m_args_overall_count );
#else
                PyObject *python_pars[ function->m_args_overall_count ];
#endif
                memset( python_pars, 0, function->m_args_overall_count * sizeof(PyObject *) );

                if ( parseArgumentsMethodPos( function, python_pars, method->m_object, args, 1 ) )
                {
                    result = function->m_c_code( function, python_pars );
                }
                else
                {
                    result = NULL;
                }
            }

            Py_LeaveRecursiveCall();

            return result;
        }
    }
    else if ( PyCFunction_Check( called ) )
    {
        // Try to be fast about wrapping the arguments.
        int flags = PyCFunction_GET_FLAGS( called ) & ~(METH_CLASS | METH_STATIC | METH_COEXIST);

        if ( flags & METH_NOARGS )
        {
#if 1 == 0
            PyCFunction method = PyCFunction_GET_FUNCTION( called );
            PyObject *self = PyCFunction_GET_SELF( called );

            // Recursion guard is not strictly necessary, as we already have
            // one on our way to here.
#ifdef _NUITKA_FULL_COMPAT
            if (unlikely( Py_EnterRecursiveCall( (char *)" while calling a Python object" ) ))
            {
                return NULL;
            }
#endif

            PyObject *result = (*method)( self, NULL );

#ifdef _NUITKA_FULL_COMPAT
            Py_LeaveRecursiveCall();
#endif

            if ( result != NULL )
            {
            // Some buggy C functions do set an error, but do not indicate it
            // and Nuitka inner workings can get upset/confused from it.
                DROP_ERROR_OCCURRED();

                return result;
            }
            else
            {
                // Other buggy C functions do this, return NULL, but with
                // no error set, not allowed.
                if (unlikely( !ERROR_OCCURRED() ))
                {
                    PyErr_Format(
                        PyExc_SystemError,
                        "NULL result without error in PyObject_Call"
                    );
                }

                return NULL;
            }
#else
            PyErr_Format(
                PyExc_TypeError,
                "%s() takes no arguments (1 given)",
                ((PyCFunctionObject *)called)->m_ml->ml_name
            );
            return NULL;
#endif
        }
        else if ( flags & METH_O )
        {
#if 1 == 1
            PyCFunction method = PyCFunction_GET_FUNCTION( called );
            PyObject *self = PyCFunction_GET_SELF( called );

            // Recursion guard is not strictly necessary, as we already have
            // one on our way to here.
#ifdef _NUITKA_FULL_COMPAT
            if (unlikely( Py_EnterRecursiveCall( (char *)" while calling a Python object" ) ))
            {
                return NULL;
            }
#endif

            PyObject *result = (*method)( self, args[0] );

#ifdef _NUITKA_FULL_COMPAT
            Py_LeaveRecursiveCall();
#endif

            if ( result != NULL )
            {
            // Some buggy C functions do set an error, but do not indicate it
            // and Nuitka inner workings can get upset/confused from it.
                DROP_ERROR_OCCURRED();

                return result;
            }
            else
            {
                // Other buggy C functions do this, return NULL, but with
                // no error set, not allowed.
                if (unlikely( !ERROR_OCCURRED() ))
                {
                    PyErr_Format(
                        PyExc_SystemError,
                        "NULL result without error in PyObject_Call"
                    );
                }

                return NULL;
            }
#else
            PyErr_Format(PyExc_TypeError,
                "%s() takes exactly one argument (1 given)",
                 ((PyCFunctionObject *)called)->m_ml->ml_name
            );
            return NULL;
#endif
        }
        else if ( flags & METH_VARARGS )
        {
            PyCFunction method = PyCFunction_GET_FUNCTION( called );
            PyObject *self = PyCFunction_GET_SELF( called );

            PyObject *pos_args = MAKE_TUPLE( args, 1 );

            PyObject *result;

            // Recursion guard is not strictly necessary, as we already have
            // one on our way to here.
#ifdef _NUITKA_FULL_COMPAT
            if (unlikely( Py_EnterRecursiveCall( (char *)" while calling a Python object" ) ))
            {
                return NULL;
            }
#endif

#if PYTHON_VERSION < 360
            if ( flags & METH_KEYWORDS )
            {
                result = (*(PyCFunctionWithKeywords)method)( self, pos_args, NULL );
            }
            else
            {
                result = (*method)( self, pos_args );
            }
#else
            if ( flags == ( METH_VARARGS | METH_KEYWORDS ) )
            {
                result = (*(PyCFunctionWithKeywords)method)( self, pos_args, NULL );
            }
            else if ( flags == METH_FASTCALL )
            {
                result = (*(_PyCFunctionFast)method)( self, &PyTuple_GET_ITEM( pos_args, 0 ), 1, NULL );;
            }
            else
            {
                result = (*method)( self, pos_args );
            }
#endif

#ifdef _NUITKA_FULL_COMPAT
            Py_LeaveRecursiveCall();
#endif

            if ( result != NULL )
            {
                // Some buggy C functions do set an error, but do not indicate it
                // and Nuitka inner workings can get upset/confused from it.
                DROP_ERROR_OCCURRED();

                Py_DECREF( pos_args );
                return result;
            }
            else
            {
                // Other buggy C functions do this, return NULL, but with
                // no error set, not allowed.
                if (unlikely( !ERROR_OCCURRED() ))
                {
                    PyErr_Format(
                        PyExc_SystemError,
                        "NULL result without error in PyObject_Call"
                    );
                }

                Py_DECREF( pos_args );
                return NULL;
            }
        }
    }
    else if ( PyFunction_Check( called ) )
    {
        return callPythonFunction(
            called,
            args,
            1
        );
    }

    PyObject *pos_args = MAKE_TUPLE( args, 1 );

    PyObject *result = CALL_FUNCTION(
        called,
        pos_args,
        NULL
    );

    Py_DECREF( pos_args );

    return result;
}

PyObject *CALL_FUNCTION_WITH_ARGS2( PyObject *called, PyObject **args )
{
    CHECK_OBJECT( called );

    // Check if arguments are valid objects in debug mode.
#ifndef __NUITKA_NO_ASSERT__
    for( size_t i = 0; i < 2; i++ )
    {
        CHECK_OBJECT( args[ i ] );
    }
#endif

    if ( Nuitka_Function_Check( called ) )
    {
        if (unlikely( Py_EnterRecursiveCall( (char *)" while calling a Python object" ) ))
        {
            return NULL;
        }

        struct Nuitka_FunctionObject *function = (struct Nuitka_FunctionObject *)called;
        PyObject *result;

        if ( function->m_args_simple && 2 == function->m_args_positional_count )
        {
            for( Py_ssize_t i = 0; i < 2; i++ )
            {
                Py_INCREF( args[ i ] );
            }

            result = function->m_c_code( function, args );
        }
        else if ( function->m_args_simple && 2 + function->m_defaults_given == function->m_args_positional_count )
        {
#ifdef _MSC_VER
            PyObject **python_pars = (PyObject **)_alloca( sizeof( PyObject * ) * function->m_args_positional_count );
#else
            PyObject *python_pars[ function->m_args_positional_count ];
#endif
            memcpy( python_pars, args, 2 * sizeof(PyObject *) );
            memcpy( python_pars + 2, &PyTuple_GET_ITEM( function->m_defaults, 0 ), function->m_defaults_given * sizeof(PyObject *) );

            for( Py_ssize_t i = 0; i < function->m_args_positional_count; i++ )
            {
                Py_INCREF( python_pars[ i ] );
            }

            result = function->m_c_code( function, python_pars );
        }
        else
        {
#ifdef _MSC_VER
            PyObject **python_pars = (PyObject **)_alloca( sizeof( PyObject * ) * function->m_args_overall_count );
#else
            PyObject *python_pars[ function->m_args_overall_count ];
#endif
            memset( python_pars, 0, function->m_args_overall_count * sizeof(PyObject *) );

            if ( parseArgumentsPos( function, python_pars, args, 2 ))
            {
                result = function->m_c_code( function, python_pars );
            }
            else
            {
                result = NULL;
            }
        }

        Py_LeaveRecursiveCall();

        return result;
    }
    else if ( Nuitka_Method_Check( called ) )
    {
        struct Nuitka_MethodObject *method = (struct Nuitka_MethodObject *)called;

        // Unbound method without arguments, let the error path be slow.
        if ( method->m_object != NULL )
        {
            if (unlikely( Py_EnterRecursiveCall( (char *)" while calling a Python object" ) ))
            {
                return NULL;
            }

            struct Nuitka_FunctionObject *function = method->m_function;

            PyObject *result;

            if ( function->m_args_simple && 2 + 1 == function->m_args_positional_count )
            {
#ifdef _MSC_VER
                PyObject **python_pars = (PyObject **)_alloca( sizeof( PyObject * ) * function->m_args_positional_count );
#else
                PyObject *python_pars[ function->m_args_positional_count ];
#endif
                python_pars[ 0 ] = method->m_object;
                Py_INCREF( method->m_object );

                for( Py_ssize_t i = 0; i < 2; i++ )
                {
                    python_pars[ i + 1 ] = args[ i ];
                    Py_INCREF( args[ i ] );
                }

                result = function->m_c_code( function, python_pars );
            }
            else if ( function->m_args_simple && 2 + 1 + function->m_defaults_given == function->m_args_positional_count )
            {
#ifdef _MSC_VER
                PyObject **python_pars = (PyObject **)_alloca( sizeof( PyObject * ) * function->m_args_positional_count );
#else
                PyObject *python_pars[ function->m_args_positional_count ];
#endif
                python_pars[ 0 ] = method->m_object;
                Py_INCREF( method->m_object );

                memcpy( python_pars+1, args, 2 * sizeof(PyObject *) );
                memcpy( python_pars+1 + 2, &PyTuple_GET_ITEM( function->m_defaults, 0 ), function->m_defaults_given * sizeof(PyObject *) );

                for( Py_ssize_t i = 1; i < function->m_args_overall_count; i++ )
                {
                    Py_INCREF( python_pars[ i ] );
                }

                result = function->m_c_code( function, python_pars );
            }
            else
            {
#ifdef _MSC_VER
                PyObject **python_pars = (PyObject **)_alloca( sizeof( PyObject * ) * function->m_args_overall_count );
#else
                PyObject *python_pars[ function->m_args_overall_count ];
#endif
                memset( python_pars, 0, function->m_args_overall_count * sizeof(PyObject *) );

                if ( parseArgumentsMethodPos( function, python_pars, method->m_object, args, 2 ) )
                {
                    result = function->m_c_code( function, python_pars );
                }
                else
                {
                    result = NULL;
                }
            }

            Py_LeaveRecursiveCall();

            return result;
        }
    }
    else if ( PyCFunction_Check( called ) )
    {
        // Try to be fast about wrapping the arguments.
        int flags = PyCFunction_GET_FLAGS( called ) & ~(METH_CLASS | METH_STATIC | METH_COEXIST);

        if ( flags & METH_NOARGS )
        {
#if 2 == 0
            PyCFunction method = PyCFunction_GET_FUNCTION( called );
            PyObject *self = PyCFunction_GET_SELF( called );

            // Recursion guard is not strictly necessary, as we already have
            // one on our way to here.
#ifdef _NUITKA_FULL_COMPAT
            if (unlikely( Py_EnterRecursiveCall( (char *)" while calling a Python object" ) ))
            {
                return NULL;
            }
#endif

            PyObject *result = (*method)( self, NULL );

#ifdef _NUITKA_FULL_COMPAT
            Py_LeaveRecursiveCall();
#endif

            if ( result != NULL )
            {
            // Some buggy C functions do set an error, but do not indicate it
            // and Nuitka inner workings can get upset/confused from it.
                DROP_ERROR_OCCURRED();

                return result;
            }
            else
            {
                // Other buggy C functions do this, return NULL, but with
                // no error set, not allowed.
                if (unlikely( !ERROR_OCCURRED() ))
                {
                    PyErr_Format(
                        PyExc_SystemError,
                        "NULL result without error in PyObject_Call"
                    );
                }

                return NULL;
            }
#else
            PyErr_Format(
                PyExc_TypeError,
                "%s() takes no arguments (2 given)",
                ((PyCFunctionObject *)called)->m_ml->ml_name
            );
            return NULL;
#endif
        }
        else if ( flags & METH_O )
        {
#if 2 == 1
            PyCFunction method = PyCFunction_GET_FUNCTION( called );
            PyObject *self = PyCFunction_GET_SELF( called );

            // Recursion guard is not strictly necessary, as we already have
            // one on our way to here.
#ifdef _NUITKA_FULL_COMPAT
            if (unlikely( Py_EnterRecursiveCall( (char *)" while calling a Python object" ) ))
            {
                return NULL;
            }
#endif

            PyObject *result = (*method)( self, args[0] );

#ifdef _NUITKA_FULL_COMPAT
            Py_LeaveRecursiveCall();
#endif

            if ( result != NULL )
            {
            // Some buggy C functions do set an error, but do not indicate it
            // and Nuitka inner workings can get upset/confused from it.
                DROP_ERROR_OCCURRED();

                return result;
            }
            else
            {
                // Other buggy C functions do this, return NULL, but with
                // no error set, not allowed.
                if (unlikely( !ERROR_OCCURRED() ))
                {
                    PyErr_Format(
                        PyExc_SystemError,
                        "NULL result without error in PyObject_Call"
                    );
                }

                return NULL;
            }
#else
            PyErr_Format(PyExc_TypeError,
                "%s() takes exactly one argument (2 given)",
                 ((PyCFunctionObject *)called)->m_ml->ml_name
            );
            return NULL;
#endif
        }
        else if ( flags & METH_VARARGS )
        {
            PyCFunction method = PyCFunction_GET_FUNCTION( called );
            PyObject *self = PyCFunction_GET_SELF( called );

            PyObject *pos_args = MAKE_TUPLE( args, 2 );

            PyObject *result;

            // Recursion guard is not strictly necessary, as we already have
            // one on our way to here.
#ifdef _NUITKA_FULL_COMPAT
            if (unlikely( Py_EnterRecursiveCall( (char *)" while calling a Python object" ) ))
            {
                return NULL;
            }
#endif

#if PYTHON_VERSION < 360
            if ( flags & METH_KEYWORDS )
            {
                result = (*(PyCFunctionWithKeywords)method)( self, pos_args, NULL );
            }
            else
            {
                result = (*method)( self, pos_args );
            }
#else
            if ( flags == ( METH_VARARGS | METH_KEYWORDS ) )
            {
                result = (*(PyCFunctionWithKeywords)method)( self, pos_args, NULL );
            }
            else if ( flags == METH_FASTCALL )
            {
                result = (*(_PyCFunctionFast)method)( self, &PyTuple_GET_ITEM( pos_args, 0 ), 2, NULL );;
            }
            else
            {
                result = (*method)( self, pos_args );
            }
#endif

#ifdef _NUITKA_FULL_COMPAT
            Py_LeaveRecursiveCall();
#endif

            if ( result != NULL )
            {
                // Some buggy C functions do set an error, but do not indicate it
                // and Nuitka inner workings can get upset/confused from it.
                DROP_ERROR_OCCURRED();

                Py_DECREF( pos_args );
                return result;
            }
            else
            {
                // Other buggy C functions do this, return NULL, but with
                // no error set, not allowed.
                if (unlikely( !ERROR_OCCURRED() ))
                {
                    PyErr_Format(
                        PyExc_SystemError,
                        "NULL result without error in PyObject_Call"
                    );
                }

                Py_DECREF( pos_args );
                return NULL;
            }
        }
    }
    else if ( PyFunction_Check( called ) )
    {
        return callPythonFunction(
            called,
            args,
            2
        );
    }

    PyObject *pos_args = MAKE_TUPLE( args, 2 );

    PyObject *result = CALL_FUNCTION(
        called,
        pos_args,
        NULL
    );

    Py_DECREF( pos_args );

    return result;
}

PyObject *CALL_FUNCTION_WITH_ARGS3( PyObject *called, PyObject **args )
{
    CHECK_OBJECT( called );

    // Check if arguments are valid objects in debug mode.
#ifndef __NUITKA_NO_ASSERT__
    for( size_t i = 0; i < 3; i++ )
    {
        CHECK_OBJECT( args[ i ] );
    }
#endif

    if ( Nuitka_Function_Check( called ) )
    {
        if (unlikely( Py_EnterRecursiveCall( (char *)" while calling a Python object" ) ))
        {
            return NULL;
        }

        struct Nuitka_FunctionObject *function = (struct Nuitka_FunctionObject *)called;
        PyObject *result;

        if ( function->m_args_simple && 3 == function->m_args_positional_count )
        {
            for( Py_ssize_t i = 0; i < 3; i++ )
            {
                Py_INCREF( args[ i ] );
            }

            result = function->m_c_code( function, args );
        }
        else if ( function->m_args_simple && 3 + function->m_defaults_given == function->m_args_positional_count )
        {
#ifdef _MSC_VER
            PyObject **python_pars = (PyObject **)_alloca( sizeof( PyObject * ) * function->m_args_positional_count );
#else
            PyObject *python_pars[ function->m_args_positional_count ];
#endif
            memcpy( python_pars, args, 3 * sizeof(PyObject *) );
            memcpy( python_pars + 3, &PyTuple_GET_ITEM( function->m_defaults, 0 ), function->m_defaults_given * sizeof(PyObject *) );

            for( Py_ssize_t i = 0; i < function->m_args_positional_count; i++ )
            {
                Py_INCREF( python_pars[ i ] );
            }

            result = function->m_c_code( function, python_pars );
        }
        else
        {
#ifdef _MSC_VER
            PyObject **python_pars = (PyObject **)_alloca( sizeof( PyObject * ) * function->m_args_overall_count );
#else
            PyObject *python_pars[ function->m_args_overall_count ];
#endif
            memset( python_pars, 0, function->m_args_overall_count * sizeof(PyObject *) );

            if ( parseArgumentsPos( function, python_pars, args, 3 ))
            {
                result = function->m_c_code( function, python_pars );
            }
            else
            {
                result = NULL;
            }
        }

        Py_LeaveRecursiveCall();

        return result;
    }
    else if ( Nuitka_Method_Check( called ) )
    {
        struct Nuitka_MethodObject *method = (struct Nuitka_MethodObject *)called;

        // Unbound method without arguments, let the error path be slow.
        if ( method->m_object != NULL )
        {
            if (unlikely( Py_EnterRecursiveCall( (char *)" while calling a Python object" ) ))
            {
                return NULL;
            }

            struct Nuitka_FunctionObject *function = method->m_function;

            PyObject *result;

            if ( function->m_args_simple && 3 + 1 == function->m_args_positional_count )
            {
#ifdef _MSC_VER
                PyObject **python_pars = (PyObject **)_alloca( sizeof( PyObject * ) * function->m_args_positional_count );
#else
                PyObject *python_pars[ function->m_args_positional_count ];
#endif
                python_pars[ 0 ] = method->m_object;
                Py_INCREF( method->m_object );

                for( Py_ssize_t i = 0; i < 3; i++ )
                {
                    python_pars[ i + 1 ] = args[ i ];
                    Py_INCREF( args[ i ] );
                }

                result = function->m_c_code( function, python_pars );
            }
            else if ( function->m_args_simple && 3 + 1 + function->m_defaults_given == function->m_args_positional_count )
            {
#ifdef _MSC_VER
                PyObject **python_pars = (PyObject **)_alloca( sizeof( PyObject * ) * function->m_args_positional_count );
#else
                PyObject *python_pars[ function->m_args_positional_count ];
#endif
                python_pars[ 0 ] = method->m_object;
                Py_INCREF( method->m_object );

                memcpy( python_pars+1, args, 3 * sizeof(PyObject *) );
                memcpy( python_pars+1 + 3, &PyTuple_GET_ITEM( function->m_defaults, 0 ), function->m_defaults_given * sizeof(PyObject *) );

                for( Py_ssize_t i = 1; i < function->m_args_overall_count; i++ )
                {
                    Py_INCREF( python_pars[ i ] );
                }

                result = function->m_c_code( function, python_pars );
            }
            else
            {
#ifdef _MSC_VER
                PyObject **python_pars = (PyObject **)_alloca( sizeof( PyObject * ) * function->m_args_overall_count );
#else
                PyObject *python_pars[ function->m_args_overall_count ];
#endif
                memset( python_pars, 0, function->m_args_overall_count * sizeof(PyObject *) );

                if ( parseArgumentsMethodPos( function, python_pars, method->m_object, args, 3 ) )
                {
                    result = function->m_c_code( function, python_pars );
                }
                else
                {
                    result = NULL;
                }
            }

            Py_LeaveRecursiveCall();

            return result;
        }
    }
    else if ( PyCFunction_Check( called ) )
    {
        // Try to be fast about wrapping the arguments.
        int flags = PyCFunction_GET_FLAGS( called ) & ~(METH_CLASS | METH_STATIC | METH_COEXIST);

        if ( flags & METH_NOARGS )
        {
#if 3 == 0
            PyCFunction method = PyCFunction_GET_FUNCTION( called );
            PyObject *self = PyCFunction_GET_SELF( called );

            // Recursion guard is not strictly necessary, as we already have
            // one on our way to here.
#ifdef _NUITKA_FULL_COMPAT
            if (unlikely( Py_EnterRecursiveCall( (char *)" while calling a Python object" ) ))
            {
                return NULL;
            }
#endif

            PyObject *result = (*method)( self, NULL );

#ifdef _NUITKA_FULL_COMPAT
            Py_LeaveRecursiveCall();
#endif

            if ( result != NULL )
            {
            // Some buggy C functions do set an error, but do not indicate it
            // and Nuitka inner workings can get upset/confused from it.
                DROP_ERROR_OCCURRED();

                return result;
            }
            else
            {
                // Other buggy C functions do this, return NULL, but with
                // no error set, not allowed.
                if (unlikely( !ERROR_OCCURRED() ))
                {
                    PyErr_Format(
                        PyExc_SystemError,
                        "NULL result without error in PyObject_Call"
                    );
                }

                return NULL;
            }
#else
            PyErr_Format(
                PyExc_TypeError,
                "%s() takes no arguments (3 given)",
                ((PyCFunctionObject *)called)->m_ml->ml_name
            );
            return NULL;
#endif
        }
        else if ( flags & METH_O )
        {
#if 3 == 1
            PyCFunction method = PyCFunction_GET_FUNCTION( called );
            PyObject *self = PyCFunction_GET_SELF( called );

            // Recursion guard is not strictly necessary, as we already have
            // one on our way to here.
#ifdef _NUITKA_FULL_COMPAT
            if (unlikely( Py_EnterRecursiveCall( (char *)" while calling a Python object" ) ))
            {
                return NULL;
            }
#endif

            PyObject *result = (*method)( self, args[0] );

#ifdef _NUITKA_FULL_COMPAT
            Py_LeaveRecursiveCall();
#endif

            if ( result != NULL )
            {
            // Some buggy C functions do set an error, but do not indicate it
            // and Nuitka inner workings can get upset/confused from it.
                DROP_ERROR_OCCURRED();

                return result;
            }
            else
            {
                // Other buggy C functions do this, return NULL, but with
                // no error set, not allowed.
                if (unlikely( !ERROR_OCCURRED() ))
                {
                    PyErr_Format(
                        PyExc_SystemError,
                        "NULL result without error in PyObject_Call"
                    );
                }

                return NULL;
            }
#else
            PyErr_Format(PyExc_TypeError,
                "%s() takes exactly one argument (3 given)",
                 ((PyCFunctionObject *)called)->m_ml->ml_name
            );
            return NULL;
#endif
        }
        else if ( flags & METH_VARARGS )
        {
            PyCFunction method = PyCFunction_GET_FUNCTION( called );
            PyObject *self = PyCFunction_GET_SELF( called );

            PyObject *pos_args = MAKE_TUPLE( args, 3 );

            PyObject *result;

            // Recursion guard is not strictly necessary, as we already have
            // one on our way to here.
#ifdef _NUITKA_FULL_COMPAT
            if (unlikely( Py_EnterRecursiveCall( (char *)" while calling a Python object" ) ))
            {
                return NULL;
            }
#endif

#if PYTHON_VERSION < 360
            if ( flags & METH_KEYWORDS )
            {
                result = (*(PyCFunctionWithKeywords)method)( self, pos_args, NULL );
            }
            else
            {
                result = (*method)( self, pos_args );
            }
#else
            if ( flags == ( METH_VARARGS | METH_KEYWORDS ) )
            {
                result = (*(PyCFunctionWithKeywords)method)( self, pos_args, NULL );
            }
            else if ( flags == METH_FASTCALL )
            {
                result = (*(_PyCFunctionFast)method)( self, &PyTuple_GET_ITEM( pos_args, 0 ), 3, NULL );;
            }
            else
            {
                result = (*method)( self, pos_args );
            }
#endif

#ifdef _NUITKA_FULL_COMPAT
            Py_LeaveRecursiveCall();
#endif

            if ( result != NULL )
            {
                // Some buggy C functions do set an error, but do not indicate it
                // and Nuitka inner workings can get upset/confused from it.
                DROP_ERROR_OCCURRED();

                Py_DECREF( pos_args );
                return result;
            }
            else
            {
                // Other buggy C functions do this, return NULL, but with
                // no error set, not allowed.
                if (unlikely( !ERROR_OCCURRED() ))
                {
                    PyErr_Format(
                        PyExc_SystemError,
                        "NULL result without error in PyObject_Call"
                    );
                }

                Py_DECREF( pos_args );
                return NULL;
            }
        }
    }
    else if ( PyFunction_Check( called ) )
    {
        return callPythonFunction(
            called,
            args,
            3
        );
    }

    PyObject *pos_args = MAKE_TUPLE( args, 3 );

    PyObject *result = CALL_FUNCTION(
        called,
        pos_args,
        NULL
    );

    Py_DECREF( pos_args );

    return result;
}

PyObject *CALL_FUNCTION_WITH_ARGS4( PyObject *called, PyObject **args )
{
    CHECK_OBJECT( called );

    // Check if arguments are valid objects in debug mode.
#ifndef __NUITKA_NO_ASSERT__
    for( size_t i = 0; i < 4; i++ )
    {
        CHECK_OBJECT( args[ i ] );
    }
#endif

    if ( Nuitka_Function_Check( called ) )
    {
        if (unlikely( Py_EnterRecursiveCall( (char *)" while calling a Python object" ) ))
        {
            return NULL;
        }

        struct Nuitka_FunctionObject *function = (struct Nuitka_FunctionObject *)called;
        PyObject *result;

        if ( function->m_args_simple && 4 == function->m_args_positional_count )
        {
            for( Py_ssize_t i = 0; i < 4; i++ )
            {
                Py_INCREF( args[ i ] );
            }

            result = function->m_c_code( function, args );
        }
        else if ( function->m_args_simple && 4 + function->m_defaults_given == function->m_args_positional_count )
        {
#ifdef _MSC_VER
            PyObject **python_pars = (PyObject **)_alloca( sizeof( PyObject * ) * function->m_args_positional_count );
#else
            PyObject *python_pars[ function->m_args_positional_count ];
#endif
            memcpy( python_pars, args, 4 * sizeof(PyObject *) );
            memcpy( python_pars + 4, &PyTuple_GET_ITEM( function->m_defaults, 0 ), function->m_defaults_given * sizeof(PyObject *) );

            for( Py_ssize_t i = 0; i < function->m_args_positional_count; i++ )
            {
                Py_INCREF( python_pars[ i ] );
            }

            result = function->m_c_code( function, python_pars );
        }
        else
        {
#ifdef _MSC_VER
            PyObject **python_pars = (PyObject **)_alloca( sizeof( PyObject * ) * function->m_args_overall_count );
#else
            PyObject *python_pars[ function->m_args_overall_count ];
#endif
            memset( python_pars, 0, function->m_args_overall_count * sizeof(PyObject *) );

            if ( parseArgumentsPos( function, python_pars, args, 4 ))
            {
                result = function->m_c_code( function, python_pars );
            }
            else
            {
                result = NULL;
            }
        }

        Py_LeaveRecursiveCall();

        return result;
    }
    else if ( Nuitka_Method_Check( called ) )
    {
        struct Nuitka_MethodObject *method = (struct Nuitka_MethodObject *)called;

        // Unbound method without arguments, let the error path be slow.
        if ( method->m_object != NULL )
        {
            if (unlikely( Py_EnterRecursiveCall( (char *)" while calling a Python object" ) ))
            {
                return NULL;
            }

            struct Nuitka_FunctionObject *function = method->m_function;

            PyObject *result;

            if ( function->m_args_simple && 4 + 1 == function->m_args_positional_count )
            {
#ifdef _MSC_VER
                PyObject **python_pars = (PyObject **)_alloca( sizeof( PyObject * ) * function->m_args_positional_count );
#else
                PyObject *python_pars[ function->m_args_positional_count ];
#endif
                python_pars[ 0 ] = method->m_object;
                Py_INCREF( method->m_object );

                for( Py_ssize_t i = 0; i < 4; i++ )
                {
                    python_pars[ i + 1 ] = args[ i ];
                    Py_INCREF( args[ i ] );
                }

                result = function->m_c_code( function, python_pars );
            }
            else if ( function->m_args_simple && 4 + 1 + function->m_defaults_given == function->m_args_positional_count )
            {
#ifdef _MSC_VER
                PyObject **python_pars = (PyObject **)_alloca( sizeof( PyObject * ) * function->m_args_positional_count );
#else
                PyObject *python_pars[ function->m_args_positional_count ];
#endif
                python_pars[ 0 ] = method->m_object;
                Py_INCREF( method->m_object );

                memcpy( python_pars+1, args, 4 * sizeof(PyObject *) );
                memcpy( python_pars+1 + 4, &PyTuple_GET_ITEM( function->m_defaults, 0 ), function->m_defaults_given * sizeof(PyObject *) );

                for( Py_ssize_t i = 1; i < function->m_args_overall_count; i++ )
                {
                    Py_INCREF( python_pars[ i ] );
                }

                result = function->m_c_code( function, python_pars );
            }
            else
            {
#ifdef _MSC_VER
                PyObject **python_pars = (PyObject **)_alloca( sizeof( PyObject * ) * function->m_args_overall_count );
#else
                PyObject *python_pars[ function->m_args_overall_count ];
#endif
                memset( python_pars, 0, function->m_args_overall_count * sizeof(PyObject *) );

                if ( parseArgumentsMethodPos( function, python_pars, method->m_object, args, 4 ) )
                {
                    result = function->m_c_code( function, python_pars );
                }
                else
                {
                    result = NULL;
                }
            }

            Py_LeaveRecursiveCall();

            return result;
        }
    }
    else if ( PyCFunction_Check( called ) )
    {
        // Try to be fast about wrapping the arguments.
        int flags = PyCFunction_GET_FLAGS( called ) & ~(METH_CLASS | METH_STATIC | METH_COEXIST);

        if ( flags & METH_NOARGS )
        {
#if 4 == 0
            PyCFunction method = PyCFunction_GET_FUNCTION( called );
            PyObject *self = PyCFunction_GET_SELF( called );

            // Recursion guard is not strictly necessary, as we already have
            // one on our way to here.
#ifdef _NUITKA_FULL_COMPAT
            if (unlikely( Py_EnterRecursiveCall( (char *)" while calling a Python object" ) ))
            {
                return NULL;
            }
#endif

            PyObject *result = (*method)( self, NULL );

#ifdef _NUITKA_FULL_COMPAT
            Py_LeaveRecursiveCall();
#endif

            if ( result != NULL )
            {
            // Some buggy C functions do set an error, but do not indicate it
            // and Nuitka inner workings can get upset/confused from it.
                DROP_ERROR_OCCURRED();

                return result;
            }
            else
            {
                // Other buggy C functions do this, return NULL, but with
                // no error set, not allowed.
                if (unlikely( !ERROR_OCCURRED() ))
                {
                    PyErr_Format(
                        PyExc_SystemError,
                        "NULL result without error in PyObject_Call"
                    );
                }

                return NULL;
            }
#else
            PyErr_Format(
                PyExc_TypeError,
                "%s() takes no arguments (4 given)",
                ((PyCFunctionObject *)called)->m_ml->ml_name
            );
            return NULL;
#endif
        }
        else if ( flags & METH_O )
        {
#if 4 == 1
            PyCFunction method = PyCFunction_GET_FUNCTION( called );
            PyObject *self = PyCFunction_GET_SELF( called );

            // Recursion guard is not strictly necessary, as we already have
            // one on our way to here.
#ifdef _NUITKA_FULL_COMPAT
            if (unlikely( Py_EnterRecursiveCall( (char *)" while calling a Python object" ) ))
            {
                return NULL;
            }
#endif

            PyObject *result = (*method)( self, args[0] );

#ifdef _NUITKA_FULL_COMPAT
            Py_LeaveRecursiveCall();
#endif

            if ( result != NULL )
            {
            // Some buggy C functions do set an error, but do not indicate it
            // and Nuitka inner workings can get upset/confused from it.
                DROP_ERROR_OCCURRED();

                return result;
            }
            else
            {
                // Other buggy C functions do this, return NULL, but with
                // no error set, not allowed.
                if (unlikely( !ERROR_OCCURRED() ))
                {
                    PyErr_Format(
                        PyExc_SystemError,
                        "NULL result without error in PyObject_Call"
                    );
                }

                return NULL;
            }
#else
            PyErr_Format(PyExc_TypeError,
                "%s() takes exactly one argument (4 given)",
                 ((PyCFunctionObject *)called)->m_ml->ml_name
            );
            return NULL;
#endif
        }
        else if ( flags & METH_VARARGS )
        {
            PyCFunction method = PyCFunction_GET_FUNCTION( called );
            PyObject *self = PyCFunction_GET_SELF( called );

            PyObject *pos_args = MAKE_TUPLE( args, 4 );

            PyObject *result;

            // Recursion guard is not strictly necessary, as we already have
            // one on our way to here.
#ifdef _NUITKA_FULL_COMPAT
            if (unlikely( Py_EnterRecursiveCall( (char *)" while calling a Python object" ) ))
            {
                return NULL;
            }
#endif

#if PYTHON_VERSION < 360
            if ( flags & METH_KEYWORDS )
            {
                result = (*(PyCFunctionWithKeywords)method)( self, pos_args, NULL );
            }
            else
            {
                result = (*method)( self, pos_args );
            }
#else
            if ( flags == ( METH_VARARGS | METH_KEYWORDS ) )
            {
                result = (*(PyCFunctionWithKeywords)method)( self, pos_args, NULL );
            }
            else if ( flags == METH_FASTCALL )
            {
                result = (*(_PyCFunctionFast)method)( self, &PyTuple_GET_ITEM( pos_args, 0 ), 4, NULL );;
            }
            else
            {
                result = (*method)( self, pos_args );
            }
#endif

#ifdef _NUITKA_FULL_COMPAT
            Py_LeaveRecursiveCall();
#endif

            if ( result != NULL )
            {
                // Some buggy C functions do set an error, but do not indicate it
                // and Nuitka inner workings can get upset/confused from it.
                DROP_ERROR_OCCURRED();

                Py_DECREF( pos_args );
                return result;
            }
            else
            {
                // Other buggy C functions do this, return NULL, but with
                // no error set, not allowed.
                if (unlikely( !ERROR_OCCURRED() ))
                {
                    PyErr_Format(
                        PyExc_SystemError,
                        "NULL result without error in PyObject_Call"
                    );
                }

                Py_DECREF( pos_args );
                return NULL;
            }
        }
    }
    else if ( PyFunction_Check( called ) )
    {
        return callPythonFunction(
            called,
            args,
            4
        );
    }

    PyObject *pos_args = MAKE_TUPLE( args, 4 );

    PyObject *result = CALL_FUNCTION(
        called,
        pos_args,
        NULL
    );

    Py_DECREF( pos_args );

    return result;
}

PyObject *CALL_FUNCTION_WITH_ARGS5( PyObject *called, PyObject **args )
{
    CHECK_OBJECT( called );

    // Check if arguments are valid objects in debug mode.
#ifndef __NUITKA_NO_ASSERT__
    for( size_t i = 0; i < 5; i++ )
    {
        CHECK_OBJECT( args[ i ] );
    }
#endif

    if ( Nuitka_Function_Check( called ) )
    {
        if (unlikely( Py_EnterRecursiveCall( (char *)" while calling a Python object" ) ))
        {
            return NULL;
        }

        struct Nuitka_FunctionObject *function = (struct Nuitka_FunctionObject *)called;
        PyObject *result;

        if ( function->m_args_simple && 5 == function->m_args_positional_count )
        {
            for( Py_ssize_t i = 0; i < 5; i++ )
            {
                Py_INCREF( args[ i ] );
            }

            result = function->m_c_code( function, args );
        }
        else if ( function->m_args_simple && 5 + function->m_defaults_given == function->m_args_positional_count )
        {
#ifdef _MSC_VER
            PyObject **python_pars = (PyObject **)_alloca( sizeof( PyObject * ) * function->m_args_positional_count );
#else
            PyObject *python_pars[ function->m_args_positional_count ];
#endif
            memcpy( python_pars, args, 5 * sizeof(PyObject *) );
            memcpy( python_pars + 5, &PyTuple_GET_ITEM( function->m_defaults, 0 ), function->m_defaults_given * sizeof(PyObject *) );

            for( Py_ssize_t i = 0; i < function->m_args_positional_count; i++ )
            {
                Py_INCREF( python_pars[ i ] );
            }

            result = function->m_c_code( function, python_pars );
        }
        else
        {
#ifdef _MSC_VER
            PyObject **python_pars = (PyObject **)_alloca( sizeof( PyObject * ) * function->m_args_overall_count );
#else
            PyObject *python_pars[ function->m_args_overall_count ];
#endif
            memset( python_pars, 0, function->m_args_overall_count * sizeof(PyObject *) );

            if ( parseArgumentsPos( function, python_pars, args, 5 ))
            {
                result = function->m_c_code( function, python_pars );
            }
            else
            {
                result = NULL;
            }
        }

        Py_LeaveRecursiveCall();

        return result;
    }
    else if ( Nuitka_Method_Check( called ) )
    {
        struct Nuitka_MethodObject *method = (struct Nuitka_MethodObject *)called;

        // Unbound method without arguments, let the error path be slow.
        if ( method->m_object != NULL )
        {
            if (unlikely( Py_EnterRecursiveCall( (char *)" while calling a Python object" ) ))
            {
                return NULL;
            }

            struct Nuitka_FunctionObject *function = method->m_function;

            PyObject *result;

            if ( function->m_args_simple && 5 + 1 == function->m_args_positional_count )
            {
#ifdef _MSC_VER
                PyObject **python_pars = (PyObject **)_alloca( sizeof( PyObject * ) * function->m_args_positional_count );
#else
                PyObject *python_pars[ function->m_args_positional_count ];
#endif
                python_pars[ 0 ] = method->m_object;
                Py_INCREF( method->m_object );

                for( Py_ssize_t i = 0; i < 5; i++ )
                {
                    python_pars[ i + 1 ] = args[ i ];
                    Py_INCREF( args[ i ] );
                }

                result = function->m_c_code( function, python_pars );
            }
            else if ( function->m_args_simple && 5 + 1 + function->m_defaults_given == function->m_args_positional_count )
            {
#ifdef _MSC_VER
                PyObject **python_pars = (PyObject **)_alloca( sizeof( PyObject * ) * function->m_args_positional_count );
#else
                PyObject *python_pars[ function->m_args_positional_count ];
#endif
                python_pars[ 0 ] = method->m_object;
                Py_INCREF( method->m_object );

                memcpy( python_pars+1, args, 5 * sizeof(PyObject *) );
                memcpy( python_pars+1 + 5, &PyTuple_GET_ITEM( function->m_defaults, 0 ), function->m_defaults_given * sizeof(PyObject *) );

                for( Py_ssize_t i = 1; i < function->m_args_overall_count; i++ )
                {
                    Py_INCREF( python_pars[ i ] );
                }

                result = function->m_c_code( function, python_pars );
            }
            else
            {
#ifdef _MSC_VER
                PyObject **python_pars = (PyObject **)_alloca( sizeof( PyObject * ) * function->m_args_overall_count );
#else
                PyObject *python_pars[ function->m_args_overall_count ];
#endif
                memset( python_pars, 0, function->m_args_overall_count * sizeof(PyObject *) );

                if ( parseArgumentsMethodPos( function, python_pars, method->m_object, args, 5 ) )
                {
                    result = function->m_c_code( function, python_pars );
                }
                else
                {
                    result = NULL;
                }
            }

            Py_LeaveRecursiveCall();

            return result;
        }
    }
    else if ( PyCFunction_Check( called ) )
    {
        // Try to be fast about wrapping the arguments.
        int flags = PyCFunction_GET_FLAGS( called ) & ~(METH_CLASS | METH_STATIC | METH_COEXIST);

        if ( flags & METH_NOARGS )
        {
#if 5 == 0
            PyCFunction method = PyCFunction_GET_FUNCTION( called );
            PyObject *self = PyCFunction_GET_SELF( called );

            // Recursion guard is not strictly necessary, as we already have
            // one on our way to here.
#ifdef _NUITKA_FULL_COMPAT
            if (unlikely( Py_EnterRecursiveCall( (char *)" while calling a Python object" ) ))
            {
                return NULL;
            }
#endif

            PyObject *result = (*method)( self, NULL );

#ifdef _NUITKA_FULL_COMPAT
            Py_LeaveRecursiveCall();
#endif

            if ( result != NULL )
            {
            // Some buggy C functions do set an error, but do not indicate it
            // and Nuitka inner workings can get upset/confused from it.
                DROP_ERROR_OCCURRED();

                return result;
            }
            else
            {
                // Other buggy C functions do this, return NULL, but with
                // no error set, not allowed.
                if (unlikely( !ERROR_OCCURRED() ))
                {
                    PyErr_Format(
                        PyExc_SystemError,
                        "NULL result without error in PyObject_Call"
                    );
                }

                return NULL;
            }
#else
            PyErr_Format(
                PyExc_TypeError,
                "%s() takes no arguments (5 given)",
                ((PyCFunctionObject *)called)->m_ml->ml_name
            );
            return NULL;
#endif
        }
        else if ( flags & METH_O )
        {
#if 5 == 1
            PyCFunction method = PyCFunction_GET_FUNCTION( called );
            PyObject *self = PyCFunction_GET_SELF( called );

            // Recursion guard is not strictly necessary, as we already have
            // one on our way to here.
#ifdef _NUITKA_FULL_COMPAT
            if (unlikely( Py_EnterRecursiveCall( (char *)" while calling a Python object" ) ))
            {
                return NULL;
            }
#endif

            PyObject *result = (*method)( self, args[0] );

#ifdef _NUITKA_FULL_COMPAT
            Py_LeaveRecursiveCall();
#endif

            if ( result != NULL )
            {
            // Some buggy C functions do set an error, but do not indicate it
            // and Nuitka inner workings can get upset/confused from it.
                DROP_ERROR_OCCURRED();

                return result;
            }
            else
            {
                // Other buggy C functions do this, return NULL, but with
                // no error set, not allowed.
                if (unlikely( !ERROR_OCCURRED() ))
                {
                    PyErr_Format(
                        PyExc_SystemError,
                        "NULL result without error in PyObject_Call"
                    );
                }

                return NULL;
            }
#else
            PyErr_Format(PyExc_TypeError,
                "%s() takes exactly one argument (5 given)",
                 ((PyCFunctionObject *)called)->m_ml->ml_name
            );
            return NULL;
#endif
        }
        else if ( flags & METH_VARARGS )
        {
            PyCFunction method = PyCFunction_GET_FUNCTION( called );
            PyObject *self = PyCFunction_GET_SELF( called );

            PyObject *pos_args = MAKE_TUPLE( args, 5 );

            PyObject *result;

            // Recursion guard is not strictly necessary, as we already have
            // one on our way to here.
#ifdef _NUITKA_FULL_COMPAT
            if (unlikely( Py_EnterRecursiveCall( (char *)" while calling a Python object" ) ))
            {
                return NULL;
            }
#endif

#if PYTHON_VERSION < 360
            if ( flags & METH_KEYWORDS )
            {
                result = (*(PyCFunctionWithKeywords)method)( self, pos_args, NULL );
            }
            else
            {
                result = (*method)( self, pos_args );
            }
#else
            if ( flags == ( METH_VARARGS | METH_KEYWORDS ) )
            {
                result = (*(PyCFunctionWithKeywords)method)( self, pos_args, NULL );
            }
            else if ( flags == METH_FASTCALL )
            {
                result = (*(_PyCFunctionFast)method)( self, &PyTuple_GET_ITEM( pos_args, 0 ), 5, NULL );;
            }
            else
            {
                result = (*method)( self, pos_args );
            }
#endif

#ifdef _NUITKA_FULL_COMPAT
            Py_LeaveRecursiveCall();
#endif

            if ( result != NULL )
            {
                // Some buggy C functions do set an error, but do not indicate it
                // and Nuitka inner workings can get upset/confused from it.
                DROP_ERROR_OCCURRED();

                Py_DECREF( pos_args );
                return result;
            }
            else
            {
                // Other buggy C functions do this, return NULL, but with
                // no error set, not allowed.
                if (unlikely( !ERROR_OCCURRED() ))
                {
                    PyErr_Format(
                        PyExc_SystemError,
                        "NULL result without error in PyObject_Call"
                    );
                }

                Py_DECREF( pos_args );
                return NULL;
            }
        }
    }
    else if ( PyFunction_Check( called ) )
    {
        return callPythonFunction(
            called,
            args,
            5
        );
    }

    PyObject *pos_args = MAKE_TUPLE( args, 5 );

    PyObject *result = CALL_FUNCTION(
        called,
        pos_args,
        NULL
    );

    Py_DECREF( pos_args );

    return result;
}
/* Code to register embedded modules for meta path based loading if any. */

#include "nuitka/unfreezing.h"

/* Table for lookup to find compiled or bytecode modules included in this
 * binary or module, or put along this binary as extension modules. We do
 * our own loading for each of these.
 */
MOD_INIT_DECL( __main__ );
static struct Nuitka_MetaPathBasedLoaderEntry meta_path_loader_entries[] =
{
    { (char *)"__main__", MOD_INIT_NAME( __main__ ), 0, 0, NUITKA_COMPILED_MODULE },
    { (char *)"_asyncio", NULL, 0, 0, NUITKA_SHLIB_FLAG },
    { (char *)"_bz2", NULL, 0, 0, NUITKA_SHLIB_FLAG },
    { (char *)"_ctypes", NULL, 0, 0, NUITKA_SHLIB_FLAG },
    { (char *)"_decimal", NULL, 0, 0, NUITKA_SHLIB_FLAG },
    { (char *)"_elementtree", NULL, 0, 0, NUITKA_SHLIB_FLAG },
    { (char *)"_hashlib", NULL, 0, 0, NUITKA_SHLIB_FLAG },
    { (char *)"_lzma", NULL, 0, 0, NUITKA_SHLIB_FLAG },
    { (char *)"_msi", NULL, 0, 0, NUITKA_SHLIB_FLAG },
    { (char *)"_multiprocessing", NULL, 0, 0, NUITKA_SHLIB_FLAG },
    { (char *)"_overlapped", NULL, 0, 0, NUITKA_SHLIB_FLAG },
    { (char *)"_socket", NULL, 0, 0, NUITKA_SHLIB_FLAG },
    { (char *)"_sqlite3", NULL, 0, 0, NUITKA_SHLIB_FLAG },
    { (char *)"_ssl", NULL, 0, 0, NUITKA_SHLIB_FLAG },
    { (char *)"_tkinter", NULL, 0, 0, NUITKA_SHLIB_FLAG },
    { (char *)"pyexpat", NULL, 0, 0, NUITKA_SHLIB_FLAG },
    { (char *)"select", NULL, 0, 0, NUITKA_SHLIB_FLAG },
    { (char *)"unicodedata", NULL, 0, 0, NUITKA_SHLIB_FLAG },
    { (char *)"__future__", NULL, 411, 4152, NUITKA_BYTECODE_FLAG },
    { (char *)"_compat_pickle", NULL, 4563, 6551, NUITKA_BYTECODE_FLAG },
    { (char *)"_dummy_thread", NULL, 11114, 4836, NUITKA_BYTECODE_FLAG },
    { (char *)"_markupbase", NULL, 15950, 7976, NUITKA_BYTECODE_FLAG },
    { (char *)"_osx_support", NULL, 23926, 9669, NUITKA_BYTECODE_FLAG },
    { (char *)"_pyio", NULL, 33595, 71349, NUITKA_BYTECODE_FLAG },
    { (char *)"_sitebuiltins", NULL, 104944, 3420, NUITKA_BYTECODE_FLAG },
    { (char *)"_strptime", NULL, 108364, 15948, NUITKA_BYTECODE_FLAG },
    { (char *)"_threading_local", NULL, 124312, 6606, NUITKA_BYTECODE_FLAG },
    { (char *)"aifc", NULL, 130918, 25920, NUITKA_BYTECODE_FLAG },
    { (char *)"argparse", NULL, 156838, 60159, NUITKA_BYTECODE_FLAG },
    { (char *)"asynchat", NULL, 216997, 6800, NUITKA_BYTECODE_FLAG },
    { (char *)"asyncio", NULL, 223797, 763, NUITKA_BYTECODE_FLAG | NUITKA_PACKAGE_FLAG },
    { (char *)"asyncio.base_events", NULL, 224560, 38740, NUITKA_BYTECODE_FLAG },
    { (char *)"asyncio.base_futures", NULL, 263300, 2032, NUITKA_BYTECODE_FLAG },
    { (char *)"asyncio.base_subprocess", NULL, 265332, 9247, NUITKA_BYTECODE_FLAG },
    { (char *)"asyncio.base_tasks", NULL, 274579, 1846, NUITKA_BYTECODE_FLAG },
    { (char *)"asyncio.compat", NULL, 276425, 717, NUITKA_BYTECODE_FLAG },
    { (char *)"asyncio.constants", NULL, 277142, 236, NUITKA_BYTECODE_FLAG },
    { (char *)"asyncio.coroutines", NULL, 277378, 8432, NUITKA_BYTECODE_FLAG },
    { (char *)"asyncio.events", NULL, 285810, 25318, NUITKA_BYTECODE_FLAG },
    { (char *)"asyncio.futures", NULL, 311128, 13682, NUITKA_BYTECODE_FLAG },
    { (char *)"asyncio.locks", NULL, 324810, 15349, NUITKA_BYTECODE_FLAG },
    { (char *)"asyncio.log", NULL, 340159, 203, NUITKA_BYTECODE_FLAG },
    { (char *)"asyncio.proactor_events", NULL, 340362, 16601, NUITKA_BYTECODE_FLAG },
    { (char *)"asyncio.protocols", NULL, 356963, 5962, NUITKA_BYTECODE_FLAG },
    { (char *)"asyncio.queues", NULL, 362925, 8389, NUITKA_BYTECODE_FLAG },
    { (char *)"asyncio.selector_events", NULL, 371314, 29821, NUITKA_BYTECODE_FLAG },
    { (char *)"asyncio.sslproto", NULL, 401135, 20311, NUITKA_BYTECODE_FLAG },
    { (char *)"asyncio.streams", NULL, 421446, 19900, NUITKA_BYTECODE_FLAG },
    { (char *)"asyncio.subprocess", NULL, 441346, 6809, NUITKA_BYTECODE_FLAG },
    { (char *)"asyncio.tasks", NULL, 448155, 18998, NUITKA_BYTECODE_FLAG },
    { (char *)"asyncio.test_utils", NULL, 467153, 17222, NUITKA_BYTECODE_FLAG },
    { (char *)"asyncio.transports", NULL, 484375, 12045, NUITKA_BYTECODE_FLAG },
    { (char *)"asyncio.windows_events", NULL, 496420, 21479, NUITKA_BYTECODE_FLAG },
    { (char *)"asyncio.windows_utils", NULL, 517899, 5367, NUITKA_BYTECODE_FLAG },
    { (char *)"asyncore", NULL, 523266, 15823, NUITKA_BYTECODE_FLAG },
    { (char *)"bdb", NULL, 539089, 16921, NUITKA_BYTECODE_FLAG },
    { (char *)"binhex", NULL, 556010, 12071, NUITKA_BYTECODE_FLAG },
    { (char *)"bisect", NULL, 568081, 2661, NUITKA_BYTECODE_FLAG },
    { (char *)"cProfile", NULL, 570742, 4196, NUITKA_BYTECODE_FLAG },
    { (char *)"calendar", NULL, 574938, 25867, NUITKA_BYTECODE_FLAG },
    { (char *)"cgi", NULL, 600805, 27799, NUITKA_BYTECODE_FLAG },
    { (char *)"cgitb", NULL, 628604, 10083, NUITKA_BYTECODE_FLAG },
    { (char *)"chunk", NULL, 638687, 4885, NUITKA_BYTECODE_FLAG },
    { (char *)"cmd", NULL, 643572, 12560, NUITKA_BYTECODE_FLAG },
    { (char *)"code", NULL, 656132, 9821, NUITKA_BYTECODE_FLAG },
    { (char *)"codeop", NULL, 665953, 6255, NUITKA_BYTECODE_FLAG },
    { (char *)"colorsys", NULL, 672208, 3296, NUITKA_BYTECODE_FLAG },
    { (char *)"compileall", NULL, 675504, 8243, NUITKA_BYTECODE_FLAG },
    { (char *)"concurrent", NULL, 683747, 109, NUITKA_BYTECODE_FLAG | NUITKA_PACKAGE_FLAG },
    { (char *)"concurrent.futures", NULL, 683856, 625, NUITKA_BYTECODE_FLAG | NUITKA_PACKAGE_FLAG },
    { (char *)"concurrent.futures._base", NULL, 684481, 20596, NUITKA_BYTECODE_FLAG },
    { (char *)"concurrent.futures.process", NULL, 705077, 15814, NUITKA_BYTECODE_FLAG },
    { (char *)"concurrent.futures.thread", NULL, 720891, 3897, NUITKA_BYTECODE_FLAG },
    { (char *)"configparser", NULL, 724788, 45211, NUITKA_BYTECODE_FLAG },
    { (char *)"contextlib", NULL, 769999, 11143, NUITKA_BYTECODE_FLAG },
    { (char *)"copy", NULL, 781142, 7064, NUITKA_BYTECODE_FLAG },
    { (char *)"csv", NULL, 788206, 11841, NUITKA_BYTECODE_FLAG },
    { (char *)"ctypes", NULL, 800047, 16045, NUITKA_BYTECODE_FLAG | NUITKA_PACKAGE_FLAG },
    { (char *)"ctypes._endian", NULL, 816092, 1909, NUITKA_BYTECODE_FLAG },
    { (char *)"ctypes.macholib", NULL, 818001, 276, NUITKA_BYTECODE_FLAG | NUITKA_PACKAGE_FLAG },
    { (char *)"ctypes.macholib.dyld", NULL, 818277, 4316, NUITKA_BYTECODE_FLAG },
    { (char *)"ctypes.macholib.dylib", NULL, 822593, 1903, NUITKA_BYTECODE_FLAG },
    { (char *)"ctypes.macholib.framework", NULL, 824496, 2183, NUITKA_BYTECODE_FLAG },
    { (char *)"ctypes.util", NULL, 826679, 7211, NUITKA_BYTECODE_FLAG },
    { (char *)"ctypes.wintypes", NULL, 833890, 5080, NUITKA_BYTECODE_FLAG },
    { (char *)"datetime", NULL, 838970, 53735, NUITKA_BYTECODE_FLAG },
    { (char *)"dbm", NULL, 892705, 4154, NUITKA_BYTECODE_FLAG | NUITKA_PACKAGE_FLAG },
    { (char *)"dbm.dumb", NULL, 896859, 8198, NUITKA_BYTECODE_FLAG },
    { (char *)"decimal", NULL, 905057, 163387, NUITKA_BYTECODE_FLAG },
    { (char *)"difflib", NULL, 1068444, 59505, NUITKA_BYTECODE_FLAG },
    { (char *)"distutils", NULL, 1127949, 361, NUITKA_BYTECODE_FLAG | NUITKA_PACKAGE_FLAG },
    { (char *)"distutils._msvccompiler", NULL, 1128310, 13506, NUITKA_BYTECODE_FLAG },
    { (char *)"distutils.archive_util", NULL, 1141816, 6356, NUITKA_BYTECODE_FLAG },
    { (char *)"distutils.bcppcompiler", NULL, 1148172, 6464, NUITKA_BYTECODE_FLAG },
    { (char *)"distutils.ccompiler", NULL, 1154636, 33330, NUITKA_BYTECODE_FLAG },
    { (char *)"distutils.cmd", NULL, 1187966, 14971, NUITKA_BYTECODE_FLAG },
    { (char *)"distutils.command", NULL, 1202937, 518, NUITKA_BYTECODE_FLAG | NUITKA_PACKAGE_FLAG },
    { (char *)"distutils.command.bdist", NULL, 1203455, 3764, NUITKA_BYTECODE_FLAG },
    { (char *)"distutils.command.bdist_dumb", NULL, 1207219, 3636, NUITKA_BYTECODE_FLAG },
    { (char *)"distutils.command.bdist_msi", NULL, 1210855, 19600, NUITKA_BYTECODE_FLAG },
    { (char *)"distutils.command.bdist_rpm", NULL, 1230455, 13052, NUITKA_BYTECODE_FLAG },
    { (char *)"distutils.command.bdist_wininst", NULL, 1243507, 8178, NUITKA_BYTECODE_FLAG },
    { (char *)"distutils.command.build", NULL, 1251685, 3956, NUITKA_BYTECODE_FLAG },
    { (char *)"distutils.command.build_clib", NULL, 1255641, 4954, NUITKA_BYTECODE_FLAG },
    { (char *)"distutils.command.build_ext", NULL, 1260595, 16426, NUITKA_BYTECODE_FLAG },
    { (char *)"distutils.command.build_py", NULL, 1277021, 10447, NUITKA_BYTECODE_FLAG },
    { (char *)"distutils.command.build_scripts", NULL, 1287468, 4317, NUITKA_BYTECODE_FLAG },
    { (char *)"distutils.command.check", NULL, 1291785, 4862, NUITKA_BYTECODE_FLAG },
    { (char *)"distutils.command.clean", NULL, 1296647, 2162, NUITKA_BYTECODE_FLAG },
    { (char *)"distutils.command.config", NULL, 1298809, 10297, NUITKA_BYTECODE_FLAG },
    { (char *)"distutils.command.install", NULL, 1309106, 13761, NUITKA_BYTECODE_FLAG },
    { (char *)"distutils.command.install_data", NULL, 1322867, 2307, NUITKA_BYTECODE_FLAG },
    { (char *)"distutils.command.install_egg_info", NULL, 1325174, 2968, NUITKA_BYTECODE_FLAG },
    { (char *)"distutils.command.install_headers", NULL, 1328142, 1707, NUITKA_BYTECODE_FLAG },
    { (char *)"distutils.command.install_lib", NULL, 1329849, 5159, NUITKA_BYTECODE_FLAG },
    { (char *)"distutils.command.install_scripts", NULL, 1335008, 2173, NUITKA_BYTECODE_FLAG },
    { (char *)"distutils.command.register", NULL, 1337181, 8395, NUITKA_BYTECODE_FLAG },
    { (char *)"distutils.command.sdist", NULL, 1345576, 12958, NUITKA_BYTECODE_FLAG },
    { (char *)"distutils.command.upload", NULL, 1358534, 5055, NUITKA_BYTECODE_FLAG },
    { (char *)"distutils.config", NULL, 1363589, 3470, NUITKA_BYTECODE_FLAG },
    { (char *)"distutils.core", NULL, 1367059, 6786, NUITKA_BYTECODE_FLAG },
    { (char *)"distutils.cygwinccompiler", NULL, 1373845, 8491, NUITKA_BYTECODE_FLAG },
    { (char *)"distutils.debug", NULL, 1382336, 171, NUITKA_BYTECODE_FLAG },
    { (char *)"distutils.dep_util", NULL, 1382507, 2687, NUITKA_BYTECODE_FLAG },
    { (char *)"distutils.dir_util", NULL, 1385194, 5787, NUITKA_BYTECODE_FLAG },
    { (char *)"distutils.dist", NULL, 1390981, 34123, NUITKA_BYTECODE_FLAG },
    { (char *)"distutils.errors", NULL, 1425104, 5457, NUITKA_BYTECODE_FLAG },
    { (char *)"distutils.extension", NULL, 1430561, 6933, NUITKA_BYTECODE_FLAG },
    { (char *)"distutils.fancy_getopt", NULL, 1437494, 10636, NUITKA_BYTECODE_FLAG },
    { (char *)"distutils.file_util", NULL, 1448130, 5880, NUITKA_BYTECODE_FLAG },
    { (char *)"distutils.filelist", NULL, 1454010, 9848, NUITKA_BYTECODE_FLAG },
    { (char *)"distutils.log", NULL, 1463858, 2244, NUITKA_BYTECODE_FLAG },
    { (char *)"distutils.msvc9compiler", NULL, 1466102, 17427, NUITKA_BYTECODE_FLAG },
    { (char *)"distutils.msvccompiler", NULL, 1483529, 14551, NUITKA_BYTECODE_FLAG },
    { (char *)"distutils.spawn", NULL, 1498080, 4956, NUITKA_BYTECODE_FLAG },
    { (char *)"distutils.sysconfig", NULL, 1503036, 11862, NUITKA_BYTECODE_FLAG },
    { (char *)"distutils.text_file", NULL, 1514898, 8441, NUITKA_BYTECODE_FLAG },
    { (char *)"distutils.unixccompiler", NULL, 1523339, 6513, NUITKA_BYTECODE_FLAG },
    { (char *)"distutils.util", NULL, 1529852, 15516, NUITKA_BYTECODE_FLAG },
    { (char *)"distutils.version", NULL, 1545368, 7337, NUITKA_BYTECODE_FLAG },
    { (char *)"distutils.versionpredicate", NULL, 1552705, 5066, NUITKA_BYTECODE_FLAG },
    { (char *)"doctest", NULL, 1557771, 75574, NUITKA_BYTECODE_FLAG },
    { (char *)"dummy_threading", NULL, 1633345, 1087, NUITKA_BYTECODE_FLAG },
    { (char *)"email", NULL, 1634432, 1654, NUITKA_BYTECODE_FLAG | NUITKA_PACKAGE_FLAG },
    { (char *)"email._encoded_words", NULL, 1636086, 5629, NUITKA_BYTECODE_FLAG },
    { (char *)"email._header_value_parser", NULL, 1641715, 75893, NUITKA_BYTECODE_FLAG },
    { (char *)"email._parseaddr", NULL, 1717608, 12425, NUITKA_BYTECODE_FLAG },
    { (char *)"email._policybase", NULL, 1730033, 14813, NUITKA_BYTECODE_FLAG },
    { (char *)"email.base64mime", NULL, 1744846, 3203, NUITKA_BYTECODE_FLAG },
    { (char *)"email.charset", NULL, 1748049, 11496, NUITKA_BYTECODE_FLAG },
    { (char *)"email.contentmanager", NULL, 1759545, 7273, NUITKA_BYTECODE_FLAG },
    { (char *)"email.encoders", NULL, 1766818, 1625, NUITKA_BYTECODE_FLAG },
    { (char *)"email.errors", NULL, 1768443, 5942, NUITKA_BYTECODE_FLAG },
    { (char *)"email.feedparser", NULL, 1774385, 10629, NUITKA_BYTECODE_FLAG },
    { (char *)"email.generator", NULL, 1785014, 12498, NUITKA_BYTECODE_FLAG },
    { (char *)"email.header", NULL, 1797512, 16465, NUITKA_BYTECODE_FLAG },
    { (char *)"email.headerregistry", NULL, 1813977, 21263, NUITKA_BYTECODE_FLAG },
    { (char *)"email.iterators", NULL, 1835240, 1895, NUITKA_BYTECODE_FLAG },
    { (char *)"email.message", NULL, 1837135, 37977, NUITKA_BYTECODE_FLAG },
    { (char *)"email.mime", NULL, 1875112, 109, NUITKA_BYTECODE_FLAG | NUITKA_PACKAGE_FLAG },
    { (char *)"email.mime.application", NULL, 1875221, 1420, NUITKA_BYTECODE_FLAG },
    { (char *)"email.mime.audio", NULL, 1876641, 2579, NUITKA_BYTECODE_FLAG },
    { (char *)"email.mime.base", NULL, 1879220, 1045, NUITKA_BYTECODE_FLAG },
    { (char *)"email.mime.image", NULL, 1880265, 1865, NUITKA_BYTECODE_FLAG },
    { (char *)"email.mime.message", NULL, 1882130, 1294, NUITKA_BYTECODE_FLAG },
    { (char *)"email.mime.multipart", NULL, 1883424, 1516, NUITKA_BYTECODE_FLAG },
    { (char *)"email.mime.nonmultipart", NULL, 1884940, 731, NUITKA_BYTECODE_FLAG },
    { (char *)"email.mime.text", NULL, 1885671, 1278, NUITKA_BYTECODE_FLAG },
    { (char *)"email.parser", NULL, 1886949, 5710, NUITKA_BYTECODE_FLAG },
    { (char *)"email.policy", NULL, 1892659, 9603, NUITKA_BYTECODE_FLAG },
    { (char *)"email.quoprimime", NULL, 1902262, 7665, NUITKA_BYTECODE_FLAG },
    { (char *)"email.utils", NULL, 1909927, 9859, NUITKA_BYTECODE_FLAG },
    { (char *)"filecmp", NULL, 1919786, 8290, NUITKA_BYTECODE_FLAG },
    { (char *)"fileinput", NULL, 1928076, 13137, NUITKA_BYTECODE_FLAG },
    { (char *)"fnmatch", NULL, 1941213, 2859, NUITKA_BYTECODE_FLAG },
    { (char *)"formatter", NULL, 1944072, 17564, NUITKA_BYTECODE_FLAG },
    { (char *)"fractions", NULL, 1961636, 18411, NUITKA_BYTECODE_FLAG },
    { (char *)"ftplib", NULL, 1980047, 28183, NUITKA_BYTECODE_FLAG },
    { (char *)"getopt", NULL, 2008230, 6202, NUITKA_BYTECODE_FLAG },
    { (char *)"getpass", NULL, 2014432, 4162, NUITKA_BYTECODE_FLAG },
    { (char *)"gettext", NULL, 2018594, 14182, NUITKA_BYTECODE_FLAG },
    { (char *)"glob", NULL, 2032776, 4244, NUITKA_BYTECODE_FLAG },
    { (char *)"gzip", NULL, 2037020, 16211, NUITKA_BYTECODE_FLAG },
    { (char *)"hashlib", NULL, 2053231, 6621, NUITKA_BYTECODE_FLAG },
    { (char *)"hmac", NULL, 2059852, 4821, NUITKA_BYTECODE_FLAG },
    { (char *)"html", NULL, 2064673, 3362, NUITKA_BYTECODE_FLAG | NUITKA_PACKAGE_FLAG },
    { (char *)"html.entities", NULL, 2068035, 50432, NUITKA_BYTECODE_FLAG },
    { (char *)"html.parser", NULL, 2118467, 11149, NUITKA_BYTECODE_FLAG },
    { (char *)"http", NULL, 2129616, 6512, NUITKA_BYTECODE_FLAG | NUITKA_PACKAGE_FLAG },
    { (char *)"http.client", NULL, 2136128, 34324, NUITKA_BYTECODE_FLAG },
    { (char *)"http.cookiejar", NULL, 2170452, 53890, NUITKA_BYTECODE_FLAG },
    { (char *)"http.cookies", NULL, 2224342, 16073, NUITKA_BYTECODE_FLAG },
    { (char *)"http.server", NULL, 2240415, 32203, NUITKA_BYTECODE_FLAG },
    { (char *)"imaplib", NULL, 2272618, 42084, NUITKA_BYTECODE_FLAG },
    { (char *)"imghdr", NULL, 2314702, 4135, NUITKA_BYTECODE_FLAG },
    { (char *)"imp", NULL, 2318837, 9681, NUITKA_BYTECODE_FLAG },
    { (char *)"importlib.abc", NULL, 2328518, 11278, NUITKA_BYTECODE_FLAG },
    { (char *)"importlib.util", NULL, 2339796, 8885, NUITKA_BYTECODE_FLAG },
    { (char *)"ipaddress", NULL, 2348681, 62646, NUITKA_BYTECODE_FLAG },
    { (char *)"json", NULL, 2411327, 12626, NUITKA_BYTECODE_FLAG | NUITKA_PACKAGE_FLAG },
    { (char *)"json.decoder", NULL, 2423953, 9940, NUITKA_BYTECODE_FLAG },
    { (char *)"json.encoder", NULL, 2433893, 11242, NUITKA_BYTECODE_FLAG },
    { (char *)"json.scanner", NULL, 2445135, 1955, NUITKA_BYTECODE_FLAG },
    { (char *)"json.tool", NULL, 2447090, 1530, NUITKA_BYTECODE_FLAG },
    { (char *)"lib2to3", NULL, 2448620, 106, NUITKA_BYTECODE_FLAG | NUITKA_PACKAGE_FLAG },
    { (char *)"lib2to3.btm_matcher", NULL, 2448726, 4917, NUITKA_BYTECODE_FLAG },
    { (char *)"lib2to3.btm_utils", NULL, 2453643, 6116, NUITKA_BYTECODE_FLAG },
    { (char *)"lib2to3.fixer_base", NULL, 2459759, 6208, NUITKA_BYTECODE_FLAG },
    { (char *)"lib2to3.fixer_util", NULL, 2465967, 12021, NUITKA_BYTECODE_FLAG },
    { (char *)"lib2to3.fixes", NULL, 2477988, 112, NUITKA_BYTECODE_FLAG | NUITKA_PACKAGE_FLAG },
    { (char *)"lib2to3.fixes.fix_apply", NULL, 2478100, 1660, NUITKA_BYTECODE_FLAG },
    { (char *)"lib2to3.fixes.fix_asserts", NULL, 2479760, 1235, NUITKA_BYTECODE_FLAG },
    { (char *)"lib2to3.fixes.fix_basestring", NULL, 2480995, 625, NUITKA_BYTECODE_FLAG },
    { (char *)"lib2to3.fixes.fix_buffer", NULL, 2481620, 770, NUITKA_BYTECODE_FLAG },
    { (char *)"lib2to3.fixes.fix_dict", NULL, 2482390, 3293, NUITKA_BYTECODE_FLAG },
    { (char *)"lib2to3.fixes.fix_except", NULL, 2485683, 2780, NUITKA_BYTECODE_FLAG },
    { (char *)"lib2to3.fixes.fix_exec", NULL, 2488463, 1111, NUITKA_BYTECODE_FLAG },
    { (char *)"lib2to3.fixes.fix_execfile", NULL, 2489574, 1645, NUITKA_BYTECODE_FLAG },
    { (char *)"lib2to3.fixes.fix_exitfunc", NULL, 2491219, 2258, NUITKA_BYTECODE_FLAG },
    { (char *)"lib2to3.fixes.fix_filter", NULL, 2493477, 2323, NUITKA_BYTECODE_FLAG },
    { (char *)"lib2to3.fixes.fix_funcattrs", NULL, 2495800, 936, NUITKA_BYTECODE_FLAG },
    { (char *)"lib2to3.fixes.fix_future", NULL, 2496736, 746, NUITKA_BYTECODE_FLAG },
    { (char *)"lib2to3.fixes.fix_getcwdu", NULL, 2497482, 750, NUITKA_BYTECODE_FLAG },
    { (char *)"lib2to3.fixes.fix_has_key", NULL, 2498232, 2880, NUITKA_BYTECODE_FLAG },
    { (char *)"lib2to3.fixes.fix_idioms", NULL, 2501112, 3865, NUITKA_BYTECODE_FLAG },
    { (char *)"lib2to3.fixes.fix_import", NULL, 2504977, 2752, NUITKA_BYTECODE_FLAG },
    { (char *)"lib2to3.fixes.fix_imports", NULL, 2507729, 4311, NUITKA_BYTECODE_FLAG },
    { (char *)"lib2to3.fixes.fix_imports2", NULL, 2512040, 510, NUITKA_BYTECODE_FLAG },
    { (char *)"lib2to3.fixes.fix_input", NULL, 2512550, 912, NUITKA_BYTECODE_FLAG },
    { (char *)"lib2to3.fixes.fix_intern", NULL, 2513462, 1124, NUITKA_BYTECODE_FLAG },
    { (char *)"lib2to3.fixes.fix_isinstance", NULL, 2514586, 1522, NUITKA_BYTECODE_FLAG },
    { (char *)"lib2to3.fixes.fix_itertools", NULL, 2516108, 1516, NUITKA_BYTECODE_FLAG },
    { (char *)"lib2to3.fixes.fix_itertools_imports", NULL, 2517624, 1571, NUITKA_BYTECODE_FLAG },
    { (char *)"lib2to3.fixes.fix_long", NULL, 2519195, 667, NUITKA_BYTECODE_FLAG },
    { (char *)"lib2to3.fixes.fix_map", NULL, 2519862, 3055, NUITKA_BYTECODE_FLAG },
    { (char *)"lib2to3.fixes.fix_metaclass", NULL, 2522917, 5338, NUITKA_BYTECODE_FLAG },
    { (char *)"lib2to3.fixes.fix_methodattrs", NULL, 2528255, 898, NUITKA_BYTECODE_FLAG },
    { (char *)"lib2to3.fixes.fix_ne", NULL, 2529153, 769, NUITKA_BYTECODE_FLAG },
    { (char *)"lib2to3.fixes.fix_next", NULL, 2529922, 3022, NUITKA_BYTECODE_FLAG },
    { (char *)"lib2to3.fixes.fix_nonzero", NULL, 2532944, 885, NUITKA_BYTECODE_FLAG },
    { (char *)"lib2to3.fixes.fix_numliterals", NULL, 2533829, 991, NUITKA_BYTECODE_FLAG },
    { (char *)"lib2to3.fixes.fix_operator", NULL, 2534820, 4199, NUITKA_BYTECODE_FLAG },
    { (char *)"lib2to3.fixes.fix_paren", NULL, 2539019, 1352, NUITKA_BYTECODE_FLAG },
    { (char *)"lib2to3.fixes.fix_print", NULL, 2540371, 2292, NUITKA_BYTECODE_FLAG },
    { (char *)"lib2to3.fixes.fix_raise", NULL, 2542663, 2211, NUITKA_BYTECODE_FLAG },
    { (char *)"lib2to3.fixes.fix_raw_input", NULL, 2544874, 757, NUITKA_BYTECODE_FLAG },
    { (char *)"lib2to3.fixes.fix_reduce", NULL, 2545631, 1092, NUITKA_BYTECODE_FLAG },
    { (char *)"lib2to3.fixes.fix_reload", NULL, 2546723, 1124, NUITKA_BYTECODE_FLAG },
    { (char *)"lib2to3.fixes.fix_renames", NULL, 2547847, 1955, NUITKA_BYTECODE_FLAG },
    { (char *)"lib2to3.fixes.fix_repr", NULL, 2549802, 807, NUITKA_BYTECODE_FLAG },
    { (char *)"lib2to3.fixes.fix_set_literal", NULL, 2550609, 1649, NUITKA_BYTECODE_FLAG },
    { (char *)"lib2to3.fixes.fix_standarderror", NULL, 2552258, 682, NUITKA_BYTECODE_FLAG },
    { (char *)"lib2to3.fixes.fix_sys_exc", NULL, 2552940, 1363, NUITKA_BYTECODE_FLAG },
    { (char *)"lib2to3.fixes.fix_throw", NULL, 2554303, 1764, NUITKA_BYTECODE_FLAG },
    { (char *)"lib2to3.fixes.fix_tuple_params", NULL, 2556067, 4558, NUITKA_BYTECODE_FLAG },
    { (char *)"lib2to3.fixes.fix_types", NULL, 2560625, 1791, NUITKA_BYTECODE_FLAG },
    { (char *)"lib2to3.fixes.fix_unicode", NULL, 2562416, 1505, NUITKA_BYTECODE_FLAG },
    { (char *)"lib2to3.fixes.fix_urllib", NULL, 2563921, 5950, NUITKA_BYTECODE_FLAG },
    { (char *)"lib2to3.fixes.fix_ws_comma", NULL, 2569871, 1085, NUITKA_BYTECODE_FLAG },
    { (char *)"lib2to3.fixes.fix_xrange", NULL, 2570956, 2500, NUITKA_BYTECODE_FLAG },
    { (char *)"lib2to3.fixes.fix_xreadlines", NULL, 2573456, 1079, NUITKA_BYTECODE_FLAG },
    { (char *)"lib2to3.fixes.fix_zip", NULL, 2574535, 1543, NUITKA_BYTECODE_FLAG },
    { (char *)"lib2to3.main", NULL, 2576078, 8509, NUITKA_BYTECODE_FLAG },
    { (char *)"lib2to3.patcomp", NULL, 2584587, 5639, NUITKA_BYTECODE_FLAG },
    { (char *)"lib2to3.pgen2", NULL, 2590226, 142, NUITKA_BYTECODE_FLAG | NUITKA_PACKAGE_FLAG },
    { (char *)"lib2to3.pgen2.driver", NULL, 2590368, 4311, NUITKA_BYTECODE_FLAG },
    { (char *)"lib2to3.pgen2.grammar", NULL, 2594679, 6839, NUITKA_BYTECODE_FLAG },
    { (char *)"lib2to3.pgen2.literals", NULL, 2601518, 1517, NUITKA_BYTECODE_FLAG },
    { (char *)"lib2to3.pgen2.parse", NULL, 2603035, 6312, NUITKA_BYTECODE_FLAG },
    { (char *)"lib2to3.pgen2.pgen", NULL, 2609347, 9768, NUITKA_BYTECODE_FLAG },
    { (char *)"lib2to3.pgen2.token", NULL, 2619115, 1835, NUITKA_BYTECODE_FLAG },
    { (char *)"lib2to3.pgen2.tokenize", NULL, 2620950, 15369, NUITKA_BYTECODE_FLAG },
    { (char *)"lib2to3.pygram", NULL, 2636319, 1139, NUITKA_BYTECODE_FLAG },
    { (char *)"lib2to3.pytree", NULL, 2637458, 25119, NUITKA_BYTECODE_FLAG },
    { (char *)"lib2to3.refactor", NULL, 2662577, 20774, NUITKA_BYTECODE_FLAG },
    { (char *)"logging", NULL, 2683351, 60263, NUITKA_BYTECODE_FLAG | NUITKA_PACKAGE_FLAG },
    { (char *)"logging.config", NULL, 2743614, 23203, NUITKA_BYTECODE_FLAG },
    { (char *)"logging.handlers", NULL, 2766817, 43237, NUITKA_BYTECODE_FLAG },
    { (char *)"lzma", NULL, 2810054, 11977, NUITKA_BYTECODE_FLAG },
    { (char *)"macpath", NULL, 2822031, 5626, NUITKA_BYTECODE_FLAG },
    { (char *)"macurl2path", NULL, 2827657, 1852, NUITKA_BYTECODE_FLAG },
    { (char *)"mailbox", NULL, 2829509, 63737, NUITKA_BYTECODE_FLAG },
    { (char *)"mailcap", NULL, 2893246, 6463, NUITKA_BYTECODE_FLAG },
    { (char *)"mimetypes", NULL, 2899709, 15528, NUITKA_BYTECODE_FLAG },
    { (char *)"modulefinder", NULL, 2915237, 15351, NUITKA_BYTECODE_FLAG },
    { (char *)"msilib", NULL, 2930588, 15925, NUITKA_BYTECODE_FLAG | NUITKA_PACKAGE_FLAG },
    { (char *)"msilib.schema", NULL, 2946513, 54184, NUITKA_BYTECODE_FLAG },
    { (char *)"msilib.sequence", NULL, 3000697, 3853, NUITKA_BYTECODE_FLAG },
    { (char *)"msilib.text", NULL, 3004550, 9997, NUITKA_BYTECODE_FLAG },
    { (char *)"multiprocessing", NULL, 3014547, 490, NUITKA_BYTECODE_FLAG | NUITKA_PACKAGE_FLAG },
    { (char *)"multiprocessing.connection", NULL, 3015037, 24766, NUITKA_BYTECODE_FLAG },
    { (char *)"multiprocessing.context", NULL, 3039803, 13081, NUITKA_BYTECODE_FLAG },
    { (char *)"multiprocessing.dummy", NULL, 3052884, 3700, NUITKA_BYTECODE_FLAG | NUITKA_PACKAGE_FLAG },
    { (char *)"multiprocessing.dummy.connection", NULL, 3056584, 2480, NUITKA_BYTECODE_FLAG },
    { (char *)"multiprocessing.forkserver", NULL, 3059064, 6756, NUITKA_BYTECODE_FLAG },
    { (char *)"multiprocessing.heap", NULL, 3065820, 6062, NUITKA_BYTECODE_FLAG },
    { (char *)"multiprocessing.managers", NULL, 3071882, 33286, NUITKA_BYTECODE_FLAG },
    { (char *)"multiprocessing.pool", NULL, 3105168, 20806, NUITKA_BYTECODE_FLAG },
    { (char *)"multiprocessing.popen_spawn_win32", NULL, 3125974, 2743, NUITKA_BYTECODE_FLAG },
    { (char *)"multiprocessing.process", NULL, 3128717, 8133, NUITKA_BYTECODE_FLAG },
    { (char *)"multiprocessing.queues", NULL, 3136850, 8919, NUITKA_BYTECODE_FLAG },
    { (char *)"multiprocessing.reduction", NULL, 3145769, 7935, NUITKA_BYTECODE_FLAG },
    { (char *)"multiprocessing.resource_sharer", NULL, 3153704, 5139, NUITKA_BYTECODE_FLAG },
    { (char *)"multiprocessing.semaphore_tracker", NULL, 3158843, 3652, NUITKA_BYTECODE_FLAG },
    { (char *)"multiprocessing.sharedctypes", NULL, 3162495, 6859, NUITKA_BYTECODE_FLAG },
    { (char *)"multiprocessing.spawn", NULL, 3169354, 6426, NUITKA_BYTECODE_FLAG },
    { (char *)"multiprocessing.synchronize", NULL, 3175780, 11202, NUITKA_BYTECODE_FLAG },
    { (char *)"multiprocessing.util", NULL, 3186982, 9545, NUITKA_BYTECODE_FLAG },
    { (char *)"netrc", NULL, 3196527, 3821, NUITKA_BYTECODE_FLAG },
    { (char *)"nntplib", NULL, 3200348, 33765, NUITKA_BYTECODE_FLAG },
    { (char *)"nturl2path", NULL, 3234113, 1484, NUITKA_BYTECODE_FLAG },
    { (char *)"numbers", NULL, 3235597, 12127, NUITKA_BYTECODE_FLAG },
    { (char *)"optparse", NULL, 3247724, 48039, NUITKA_BYTECODE_FLAG },
    { (char *)"pathlib", NULL, 3295763, 40728, NUITKA_BYTECODE_FLAG },
    { (char *)"pdb", NULL, 3336491, 46079, NUITKA_BYTECODE_FLAG },
    { (char *)"pickle", NULL, 3382570, 42676, NUITKA_BYTECODE_FLAG },
    { (char *)"pickletools", NULL, 3425246, 66031, NUITKA_BYTECODE_FLAG },
    { (char *)"pipes", NULL, 3491277, 7793, NUITKA_BYTECODE_FLAG },
    { (char *)"pkgutil", NULL, 3499070, 16246, NUITKA_BYTECODE_FLAG },
    { (char *)"platform", NULL, 3515316, 27969, NUITKA_BYTECODE_FLAG },
    { (char *)"plistlib", NULL, 3543285, 27603, NUITKA_BYTECODE_FLAG },
    { (char *)"poplib", NULL, 3570888, 13312, NUITKA_BYTECODE_FLAG },
    { (char *)"posixpath", NULL, 3584200, 10374, NUITKA_BYTECODE_FLAG },
    { (char *)"pprint", NULL, 3594574, 15809, NUITKA_BYTECODE_FLAG },
    { (char *)"profile", NULL, 3610383, 13886, NUITKA_BYTECODE_FLAG },
    { (char *)"pstats", NULL, 3624269, 21842, NUITKA_BYTECODE_FLAG },
    { (char *)"py_compile", NULL, 3646111, 6529, NUITKA_BYTECODE_FLAG },
    { (char *)"pyclbr", NULL, 3652640, 8350, NUITKA_BYTECODE_FLAG },
    { (char *)"pydoc", NULL, 3660990, 83896, NUITKA_BYTECODE_FLAG },
    { (char *)"pydoc_data", NULL, 3744886, 109, NUITKA_BYTECODE_FLAG | NUITKA_PACKAGE_FLAG },
    { (char *)"pydoc_data.topics", NULL, 3744995, 396635, NUITKA_BYTECODE_FLAG },
    { (char *)"queue", NULL, 4141630, 8740, NUITKA_BYTECODE_FLAG },
    { (char *)"random", NULL, 4150370, 19227, NUITKA_BYTECODE_FLAG },
    { (char *)"rlcompleter", NULL, 4169597, 5765, NUITKA_BYTECODE_FLAG },
    { (char *)"runpy", NULL, 4175362, 7918, NUITKA_BYTECODE_FLAG },
    { (char *)"sched", NULL, 4183280, 6549, NUITKA_BYTECODE_FLAG },
    { (char *)"secrets", NULL, 4189829, 2147, NUITKA_BYTECODE_FLAG },
    { (char *)"selectors", NULL, 4191976, 17682, NUITKA_BYTECODE_FLAG },
    { (char *)"shelve", NULL, 4209658, 9456, NUITKA_BYTECODE_FLAG },
    { (char *)"shlex", NULL, 4219114, 6955, NUITKA_BYTECODE_FLAG },
    { (char *)"shutil", NULL, 4226069, 30370, NUITKA_BYTECODE_FLAG },
    { (char *)"signal", NULL, 4256439, 2500, NUITKA_BYTECODE_FLAG },
    { (char *)"site", NULL, 4258939, 12410, NUITKA_BYTECODE_FLAG },
    { (char *)"smtpd", NULL, 4271349, 26668, NUITKA_BYTECODE_FLAG },
    { (char *)"smtplib", NULL, 4298017, 35281, NUITKA_BYTECODE_FLAG },
    { (char *)"sndhdr", NULL, 4333298, 6898, NUITKA_BYTECODE_FLAG },
    { (char *)"socket", NULL, 4340196, 21998, NUITKA_BYTECODE_FLAG },
    { (char *)"socketserver", NULL, 4362194, 23614, NUITKA_BYTECODE_FLAG },
    { (char *)"sqlite3", NULL, 4385808, 137, NUITKA_BYTECODE_FLAG | NUITKA_PACKAGE_FLAG },
    { (char *)"sqlite3.dbapi2", NULL, 4385945, 2456, NUITKA_BYTECODE_FLAG },
    { (char *)"sqlite3.dump", NULL, 4388401, 1899, NUITKA_BYTECODE_FLAG },
    { (char *)"ssl", NULL, 4390300, 36120, NUITKA_BYTECODE_FLAG },
    { (char *)"statistics", NULL, 4426420, 18159, NUITKA_BYTECODE_FLAG },
    { (char *)"string", NULL, 4444579, 7949, NUITKA_BYTECODE_FLAG },
    { (char *)"subprocess", NULL, 4452528, 35141, NUITKA_BYTECODE_FLAG },
    { (char *)"sunau", NULL, 4487669, 16923, NUITKA_BYTECODE_FLAG },
    { (char *)"symbol", NULL, 4504592, 2502, NUITKA_BYTECODE_FLAG },
    { (char *)"symtable", NULL, 4507094, 10413, NUITKA_BYTECODE_FLAG },
    { (char *)"sysconfig", NULL, 4517507, 15816, NUITKA_BYTECODE_FLAG },
    { (char *)"tabnanny", NULL, 4533323, 6960, NUITKA_BYTECODE_FLAG },
    { (char *)"tarfile", NULL, 4540283, 62570, NUITKA_BYTECODE_FLAG },
    { (char *)"telnetlib", NULL, 4602853, 18082, NUITKA_BYTECODE_FLAG },
    { (char *)"tempfile", NULL, 4620935, 22116, NUITKA_BYTECODE_FLAG },
    { (char *)"test", NULL, 4643051, 103, NUITKA_BYTECODE_FLAG | NUITKA_PACKAGE_FLAG },
    { (char *)"test.support", NULL, 4643154, 75211, NUITKA_BYTECODE_FLAG | NUITKA_PACKAGE_FLAG },
    { (char *)"textwrap", NULL, 4718365, 13669, NUITKA_BYTECODE_FLAG },
    { (char *)"this", NULL, 4732034, 1250, NUITKA_BYTECODE_FLAG },
    { (char *)"timeit", NULL, 4733284, 11588, NUITKA_BYTECODE_FLAG },
    { (char *)"tkinter", NULL, 4744872, 179495, NUITKA_BYTECODE_FLAG | NUITKA_PACKAGE_FLAG },
    { (char *)"tkinter.colorchooser", NULL, 4924367, 1102, NUITKA_BYTECODE_FLAG },
    { (char *)"tkinter.commondialog", NULL, 4925469, 1081, NUITKA_BYTECODE_FLAG },
    { (char *)"tkinter.constants", NULL, 4926550, 1631, NUITKA_BYTECODE_FLAG },
    { (char *)"tkinter.dialog", NULL, 4928181, 1426, NUITKA_BYTECODE_FLAG },
    { (char *)"tkinter.dnd", NULL, 4929607, 11149, NUITKA_BYTECODE_FLAG },
    { (char *)"tkinter.filedialog", NULL, 4940756, 12260, NUITKA_BYTECODE_FLAG },
    { (char *)"tkinter.font", NULL, 4953016, 6145, NUITKA_BYTECODE_FLAG },
    { (char *)"tkinter.messagebox", NULL, 4959161, 3015, NUITKA_BYTECODE_FLAG },
    { (char *)"tkinter.scrolledtext", NULL, 4962176, 2142, NUITKA_BYTECODE_FLAG },
    { (char *)"tkinter.simpledialog", NULL, 4964318, 10514, NUITKA_BYTECODE_FLAG },
    { (char *)"tkinter.tix", NULL, 4974832, 83638, NUITKA_BYTECODE_FLAG },
    { (char *)"tkinter.ttk", NULL, 5058470, 56923, NUITKA_BYTECODE_FLAG },
    { (char *)"trace", NULL, 5115393, 19564, NUITKA_BYTECODE_FLAG },
    { (char *)"tracemalloc", NULL, 5134957, 17214, NUITKA_BYTECODE_FLAG },
    { (char *)"turtle", NULL, 5152171, 131597, NUITKA_BYTECODE_FLAG },
    { (char *)"typing", NULL, 5283768, 73155, NUITKA_BYTECODE_FLAG },
    { (char *)"unittest", NULL, 5356923, 2974, NUITKA_BYTECODE_FLAG | NUITKA_PACKAGE_FLAG },
    { (char *)"unittest.case", NULL, 5359897, 47622, NUITKA_BYTECODE_FLAG },
    { (char *)"unittest.loader", NULL, 5407519, 13851, NUITKA_BYTECODE_FLAG },
    { (char *)"unittest.main", NULL, 5421370, 6997, NUITKA_BYTECODE_FLAG },
    { (char *)"unittest.mock", NULL, 5428367, 61741, NUITKA_BYTECODE_FLAG },
    { (char *)"unittest.result", NULL, 5490108, 7211, NUITKA_BYTECODE_FLAG },
    { (char *)"unittest.runner", NULL, 5497319, 6841, NUITKA_BYTECODE_FLAG },
    { (char *)"unittest.signals", NULL, 5504160, 2157, NUITKA_BYTECODE_FLAG },
    { (char *)"unittest.suite", NULL, 5506317, 9156, NUITKA_BYTECODE_FLAG },
    { (char *)"unittest.util", NULL, 5515473, 4738, NUITKA_BYTECODE_FLAG },
    { (char *)"urllib", NULL, 5520211, 105, NUITKA_BYTECODE_FLAG | NUITKA_PACKAGE_FLAG },
    { (char *)"urllib.error", NULL, 5520316, 2739, NUITKA_BYTECODE_FLAG },
    { (char *)"urllib.parse", NULL, 5523055, 29374, NUITKA_BYTECODE_FLAG },
    { (char *)"urllib.request", NULL, 5552429, 72599, NUITKA_BYTECODE_FLAG },
    { (char *)"urllib.response", NULL, 5625028, 3212, NUITKA_BYTECODE_FLAG },
    { (char *)"urllib.robotparser", NULL, 5628240, 6992, NUITKA_BYTECODE_FLAG },
    { (char *)"uu", NULL, 5635232, 3483, NUITKA_BYTECODE_FLAG },
    { (char *)"uuid", NULL, 5638715, 20716, NUITKA_BYTECODE_FLAG },
    { (char *)"venv", NULL, 5659431, 13621, NUITKA_BYTECODE_FLAG | NUITKA_PACKAGE_FLAG },
    { (char *)"wave", NULL, 5673052, 17870, NUITKA_BYTECODE_FLAG },
    { (char *)"webbrowser", NULL, 5690922, 15833, NUITKA_BYTECODE_FLAG },
    { (char *)"wsgiref", NULL, 5706755, 701, NUITKA_BYTECODE_FLAG | NUITKA_PACKAGE_FLAG },
    { (char *)"wsgiref.handlers", NULL, 5707456, 16133, NUITKA_BYTECODE_FLAG },
    { (char *)"wsgiref.headers", NULL, 5723589, 7722, NUITKA_BYTECODE_FLAG },
    { (char *)"wsgiref.simple_server", NULL, 5731311, 5178, NUITKA_BYTECODE_FLAG },
    { (char *)"wsgiref.util", NULL, 5736489, 5177, NUITKA_BYTECODE_FLAG },
    { (char *)"wsgiref.validate", NULL, 5741666, 14785, NUITKA_BYTECODE_FLAG },
    { (char *)"xdrlib", NULL, 5756451, 8287, NUITKA_BYTECODE_FLAG },
    { (char *)"xml", NULL, 5764738, 669, NUITKA_BYTECODE_FLAG | NUITKA_PACKAGE_FLAG },
    { (char *)"xml.dom", NULL, 5765407, 5416, NUITKA_BYTECODE_FLAG | NUITKA_PACKAGE_FLAG },
    { (char *)"xml.dom.NodeFilter", NULL, 5770823, 936, NUITKA_BYTECODE_FLAG },
    { (char *)"xml.dom.domreg", NULL, 5771759, 2744, NUITKA_BYTECODE_FLAG },
    { (char *)"xml.dom.expatbuilder", NULL, 5774503, 27129, NUITKA_BYTECODE_FLAG },
    { (char *)"xml.dom.minicompat", NULL, 5801632, 2774, NUITKA_BYTECODE_FLAG },
    { (char *)"xml.dom.minidom", NULL, 5804406, 55831, NUITKA_BYTECODE_FLAG },
    { (char *)"xml.dom.pulldom", NULL, 5860237, 10520, NUITKA_BYTECODE_FLAG },
    { (char *)"xml.dom.xmlbuilder", NULL, 5870757, 13536, NUITKA_BYTECODE_FLAG },
    { (char *)"xml.etree", NULL, 5884293, 108, NUITKA_BYTECODE_FLAG | NUITKA_PACKAGE_FLAG },
    { (char *)"xml.etree.ElementInclude", NULL, 5884401, 1544, NUITKA_BYTECODE_FLAG },
    { (char *)"xml.etree.ElementPath", NULL, 5885945, 6120, NUITKA_BYTECODE_FLAG },
    { (char *)"xml.etree.ElementTree", NULL, 5892065, 44713, NUITKA_BYTECODE_FLAG },
    { (char *)"xml.etree.cElementTree", NULL, 5936778, 150, NUITKA_BYTECODE_FLAG },
    { (char *)"xml.parsers", NULL, 5936928, 282, NUITKA_BYTECODE_FLAG | NUITKA_PACKAGE_FLAG },
    { (char *)"xml.parsers.expat", NULL, 5937210, 311, NUITKA_BYTECODE_FLAG },
    { (char *)"xml.sax", NULL, 5937521, 3106, NUITKA_BYTECODE_FLAG | NUITKA_PACKAGE_FLAG },
    { (char *)"xml.sax._exceptions", NULL, 5940627, 5450, NUITKA_BYTECODE_FLAG },
    { (char *)"xml.sax.expatreader", NULL, 5946077, 12383, NUITKA_BYTECODE_FLAG },
    { (char *)"xml.sax.handler", NULL, 5958460, 12298, NUITKA_BYTECODE_FLAG },
    { (char *)"xml.sax.saxutils", NULL, 5970758, 12792, NUITKA_BYTECODE_FLAG },
    { (char *)"xml.sax.xmlreader", NULL, 5983550, 16907, NUITKA_BYTECODE_FLAG },
    { (char *)"xmlrpc", NULL, 6000457, 105, NUITKA_BYTECODE_FLAG | NUITKA_PACKAGE_FLAG },
    { (char *)"xmlrpc.client", NULL, 6000562, 34648, NUITKA_BYTECODE_FLAG },
    { (char *)"xmlrpc.server", NULL, 6035210, 29539, NUITKA_BYTECODE_FLAG },
    { (char *)"zipapp", NULL, 6064749, 5519, NUITKA_BYTECODE_FLAG },
    { (char *)"zipfile", NULL, 6070268, 48189, NUITKA_BYTECODE_FLAG },
    { NULL, NULL, 0, 0, 0 }
};

void setupMetaPathBasedLoader( void )
{
    static bool init_done = false;

    if ( init_done == false )
    {
        registerMetaPathBasedUnfreezer( meta_path_loader_entries );
        init_done = true;
    }
}
