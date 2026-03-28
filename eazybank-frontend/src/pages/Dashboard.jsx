import {
  CreditCardIcon,
  CurrencyDollarIcon,
  UserGroupIcon,
} from "@heroicons/react/outline";
import { Link } from "react-router-dom";

const stats = [
  {
    id: 1,
    name: "Total Balance",
    value: "$24,563.00",
    icon: CurrencyDollarIcon,
    to: "/accounts",
  },
  {
    id: 2,
    name: "Active Cards",
    value: "3",
    icon: CreditCardIcon,
    to: "/cards",
  },
  {
    id: 3,
    name: "Active Loans",
    value: "1",
    icon: UserGroupIcon,
    to: "/loans",
  },
];

export const Dashboard = () => {
  return (
    <div className="py-6">
      <div className="px-4 sm:px-6">
        <h1 className="text-2xl font-semibold text-gray-900">Dashboard</h1>
      </div>
      <div className="mt-8">
        <div className="grid grid-cols-1 gap-5 sm:grid-cols-2 lg:grid-cols-3">
          {stats.map((stat) => (
            <Link
              key={stat.id}
              to={stat.to}
              className="bg-white overflow-hidden shadow rounded-lg hover:shadow-md"
            >
              <div className="p-5">
                <div className="flex items-center">
                  <div className="flex-shrink-0">
                    <stat.icon className="h-6 w-6 text-gray-400" />
                  </div>
                  <div className="ml-5 w-0 flex-1">
                    <dl>
                      <dt className="text-sm font-medium text-gray-500 truncate">
                        {stat.name}
                      </dt>
                      <dd className="flex items-baseline">
                        <div className="text-2xl font-semibold text-gray-900">
                          {stat.value}
                        </div>
                      </dd>
                    </dl>
                  </div>
                </div>
              </div>
            </Link>
          ))}
        </div>
      </div>
    </div>
  );
};

export default Dashboard;
