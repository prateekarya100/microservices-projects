import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom';
import { QueryClient, QueryClientProvider } from '@tanstack/react-query';
import { Dashboard } from './pages/Dashboard';
import { Accounts } from './pages/Accounts';
import { Cards } from './pages/Cards';
import { Loans } from './pages/Loans';
import { Login } from './pages/Login';
import { Layout } from './components/Layout';

const queryClient = new QueryClient();

const ProtectedRoute = ({ children }) => {
  const token = localStorage.getItem('authToken');
  return token ? children : <Navigate to="/login" replace />;
};

function App() {
  return (
    <QueryClientProvider client={queryClient}>
      <Router>
        <Routes>
          <Route path="/login" element={<Login />} />
          <Route path="/" element={
            <ProtectedRoute>
              <Layout />
            </ProtectedRoute>
          }>
            <Route index element={<Dashboard />} />
            <Route path="accounts" element={<Accounts />} />
            <Route path="cards" element={<Cards />} />
            <Route path="loans" element={<Loans />} />
          </Route>
        </Routes>
      </Router>
    </QueryClientProvider>
  );
}

export default App;