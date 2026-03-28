import { useQuery } from "@tanstack/react-query";
import { getAccounts } from "../services/accountService";

export const Accounts = () => {
  const {
    data: accounts,
    isLoading,
    error,
  } = useQuery(["accounts"], getAccounts);

  if (isLoading)
    return <div className="text-center py-4">Loading accounts...</div>;
  if (error)
    return (
      <div className="text-center py-4 text-red-500">
        Error loading accounts
      </div>
    );

  return (
    <div className="py-6">
      <div className="px-4 sm:px-6">
        <h1 className="text-2xl font-semibold text-gray-900">Accounts</h1>
      </div>
      <div className="mt-8">
        <div className="bg-white shadow overflow-hidden sm:rounded-lg">
          <ul className="divide-y divide-gray-200">
            {accounts?.map((account) => (
              <li key={account.id}>
                <div className="px-4 py-4 sm:px-6">
                  <div className="flex items-center justify-between">
                    <p className="text-sm font-medium text-primary-600 truncate">
                      {account.accountType} - {account.accountNumber}
                    </p>
                    <div className="ml-2 flex-shrink-0 flex">
                      <p className="px-2 inline-flex text-xs leading-5 font-semibold rounded-full bg-green-100 text-green-800">
                        {account.branchAddress}
                      </p>
                    </div>
                  </div>
                  <div className="mt-2 sm:flex sm:justify-between">
                    <div className="sm:flex">
                      <p className="flex items-center text-sm text-gray-500">
                        Balance: ${account.balance?.toLocaleString()}
                      </p>
                    </div>
                    <div className="mt-2 flex items-center text-sm text-gray-500 sm:mt-0">
                      <p>
                        Created on{" "}
                        <time dateTime={account.createdAt}>
                          {new Date(account.createdAt).toLocaleDateString()}
                        </time>
                      </p>
                    </div>
                  </div>
                </div>
              </li>
            ))}
          </ul>
        </div>
      </div>
    </div>
  );
};
export default Accounts;
